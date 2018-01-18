package com.sprinthive.starter.cqrs.read.dob;

import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder
public class DobMessage {

    private String entityKey;
    private String entityId;
    private String action;
    private DobPayload payload;
}
