package com.balabasciuc.springmicroservicesinaction.facultateservice.Events.Source;

import com.balabasciuc.springmicroservicesinaction.facultateservice.Events.Model.FacultateChangeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SimpleSourceBean {

    private Source source;

    @Autowired
    public SimpleSourceBean(Source source) {
        this.source = source;
    }



    private static final Logger logger = LoggerFactory.getLogger(SimpleSourceBean.class);

    public void publishFacultateChange(String action, String facultateId)
    {
        logger.debug("Sending Kafka message {} for Facultate id: {}", action, facultateId);
        FacultateChangeModel changeModel = new FacultateChangeModel(FacultateChangeModel.class.getTypeName(),
                action, facultateId);

        source.output().send(MessageBuilder.withPayload(changeModel).build());
    }

}
