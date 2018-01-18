package com.sprinthive.starter.cqrs.read.dob;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DobRepository extends MongoRepository<DobEntity, String> {
    DobEntity findByEntityKeyAndEntityId(String entityKey, String entityId);
}
