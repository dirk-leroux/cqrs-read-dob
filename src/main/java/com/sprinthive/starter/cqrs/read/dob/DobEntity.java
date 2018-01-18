package com.sprinthive.starter.cqrs.read.dob;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Value
@Builder
@Document(collection = "DOB-store")
public class DobEntity {

    private Instant dateCreated = Instant.now();
    private String entityKey;
    private String entityId;
    private Date dob;
    private Map data;
}
