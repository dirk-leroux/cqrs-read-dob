package com.sprinthive.starter;

import com.sprinthive.starter.cqrs.read.dob.DobConsumer;
import com.sprinthive.starter.cqrs.read.dob.DobRepository;
import com.sprinthive.starter.cqrs.read.dob.DobService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DobConfig {

    @Bean
    public DobService dobService(DobRepository dobRepo, MongoTemplate mongoTemplate) {
        return new DobService(dobRepo, mongoTemplate);
    }

    @Bean
    DobConsumer dobConsumer(DobService dobService) {
        return new DobConsumer(dobService);
    }

}
