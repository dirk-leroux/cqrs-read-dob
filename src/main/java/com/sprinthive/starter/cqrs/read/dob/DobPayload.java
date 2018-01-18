package com.sprinthive.starter.cqrs.read.dob;

import lombok.Builder;
import lombok.Value;

import java.util.Date;
import java.util.Map;

@Value
@Builder
public class DobPayload {

    private Date dateOfBirth;
    private Map data;
}
