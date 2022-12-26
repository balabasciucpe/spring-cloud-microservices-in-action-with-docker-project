package com.balabasciuc.springmicroservicesinaction.student.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CustomChannels.class)
public class FacultateChangeHandler {

    private static final Logger logger = LoggerFactory.getLogger(FacultateChangeHandler.class);

    @StreamListener("inboundOrgChanges")
    public void loggerSink(FacultateChangeModel facultateChangeModel)
    {
        logger.debug("Received a message of type: " + facultateChangeModel.getType());
        logger.debug("Received a message with an event {} from the facultate service for the facultate id {} ",
                facultateChangeModel.getType(), facultateChangeModel.getFacultateId());
    }

}
