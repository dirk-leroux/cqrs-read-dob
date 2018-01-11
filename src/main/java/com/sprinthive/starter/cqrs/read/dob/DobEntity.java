package com.sprinthive.starter.cqrs.read.dob;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Document(collection = "DOB-store")
public class DobEntity {

    Instant dateCreated = Instant.now();
    String entityKey;
    String entityId;
    Date dob;
}
