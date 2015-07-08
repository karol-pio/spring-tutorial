package com.acme.order.notification;

import org.springframework.stereotype.Component;

@Component
public interface MessageTemplateService {

	DeliveryTemplate getDeliveryTemplate();

	OrderCancelledTemplate getCancelTemplate();

}
