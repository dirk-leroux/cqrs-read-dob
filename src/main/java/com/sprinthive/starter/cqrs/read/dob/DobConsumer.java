package com.sprinthive.starter.cqrs.read.dob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

@Slf4j
public class DobConsumer {

    private final DobService dobService;

    public DobConsumer(DobService dobService) {
        this.dobService = dobService;
    }


//    @StreamListener(target = Sink.INPUT, condition = "headers['type']=='bar'")
//    public void receiveBar(@Payload BarPojo barPojo) {
//        // handle the message
//    }

    @StreamListener("dobMessageConsumer")
    public void dobUpdated(@Payload DobMessage msg) {
        log.info("Received {}: {}, {}, \n{}",
                msg.getEntityKey(),
                msg.getEntityId(),
                msg.getAction(),
                msg.toString());
        dobService.setDob(msg.getEntityKey(),
                msg.getEntityId(),
                msg.getPayload().getDateOfBirth(),
                msg.getPayload().getData());
    }
}
