package com.sprinthive.starter.cqrs.read.dob;

import com.sprinthive.starter.PropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class DobController {

    @Autowired
    PropsService propsService;

    @Autowired
    DobService dobService;

    @RequestMapping(value = "/cqrs/read/dob/v1/{entityKey}/{entityId}")
    private Date readDobV1(@PathVariable String entityKey,
                           @PathVariable String entityId) {
        dobService.findDob(entityKey, entityId);
        return dobService.findDob(entityKey, entityId);
    }

    @RequestMapping(value = "/cqrs/read/any/v1/{entityKey}/{entityId}")
    private List<DobEntity> readAny(@PathVariable String entityKey,
                              @PathVariable String entityId) {
        return dobService.getValues(entityKey, entityId);
    }
}
