package com.balabasciuc.springmicroservicesinaction.studentservicee.Handler;

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
        switch(facultateChangeModel.getAction())
        {
            case "GET":
                logger.debug("received a GET action from facultate-service for id " + facultateChangeModel.getFacultateId());
                break;
            case "POST":
                logger.debug("Received a POST action from Facultate-Service for id : " + facultateChangeModel.getFacultateId());
                break;
            default:
                logger.error("some error occured");
                break;
        }
    }

}
