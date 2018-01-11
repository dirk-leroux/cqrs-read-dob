package com.sprinthive.starter.cqrs.read.dob;

import com.sprinthive.starter.PropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DobController {

    @Autowired
    PropsService propsService;

    @Autowired
    DobService dobService;

    @RequestMapping(value = "/cqrs/read/dob/v1/{entityKey}/{entityId}")
    private DobEntity readDobV1(@PathVariable String entityKey,
                                 @PathVariable String entityId) {
        dobService.findDob(entityKey, entityId);
        return dobService.findDob(entityKey, entityId);
    }
}
