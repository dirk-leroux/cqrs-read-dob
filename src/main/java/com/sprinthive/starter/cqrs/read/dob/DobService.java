package com.sprinthive.starter.cqrs.read.dob;

import org.springframework.stereotype.Service;

@Service
public class DobService {

    private final DobRepository dobRepo;

    public DobService(DobRepository dobRepo) {
        this.dobRepo = dobRepo;
    }

    public DobEntity findDob(String entityKey, String entityId) {
        DobEntity dobEntity = dobRepo.findByEntityKeyAndEntityId(entityKey, entityId);
        if (dobEntity == null) {
            throw new DobNotFoundException("No dobEntity found for "+entityKey+": "+entityId);
        }
        return dobEntity;
    }

}
