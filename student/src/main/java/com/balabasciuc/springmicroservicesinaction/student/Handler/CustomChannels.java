package com.balabasciuc.springmicroservicesinaction.student.Handler;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomChannels {

    @Input("inboundOrgChanges")
    SubscribableChannel orgs();
}
