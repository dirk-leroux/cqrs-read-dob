package com.sprinthive.starter.cqrs.read.dob;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DobService {

    private final DobRepository dobRepo;
    private final MongoTemplate mongoTemplate;

    public DobService(DobRepository dobRepo, MongoTemplate mongoTemplate) {
        this.dobRepo = dobRepo;
        this.mongoTemplate = mongoTemplate;
    }

    public Date findDob(String entityKey, String entityId) {
        DobEntity dobEntity = dobRepo.findByEntityKeyAndEntityId(entityKey, entityId);
        if (dobEntity == null) {
            throw new DobNotFoundException("No dobEntity found for "+entityKey+": "+entityId);
        }
        return dobEntity.getDob();
    }

    public void setDob(String entityKey, String entityId, Date dob, Map data) {
        DobEntity dobEntity = dobRepo.findByEntityKeyAndEntityId(entityKey, entityId);
        if (dobEntity == null) {
            dobEntity = new DobEntity(entityKey, entityId, dob, data);
        }else{
            dobEntity = dobEntity.builder().dob(dob).data(data).build();
        }
        dobRepo.save(dobEntity);
    }


    public List<DobEntity> getValues(String entityKey, String entityId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("entityKey").is(entityKey).and("entityId").is(entityId));
        List<DobEntity> data = mongoTemplate.find(query, DobEntity.class);
        return data;
    }

}
