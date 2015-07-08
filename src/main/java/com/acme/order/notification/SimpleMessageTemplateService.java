package com.acme.order.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleMessageTemplateService implements MessageTemplateService {

	@Autowired
	private  DeliveryTemplate deliveryTemplate;
	@Autowired
	private  OrderCancelledTemplate cancelDeliveryTemplate;

	public SimpleMessageTemplateService(DeliveryTemplate deliveryTemplate, OrderCancelledTemplate cancelDeliveryTemplate) {
		this.deliveryTemplate = deliveryTemplate;
		this.cancelDeliveryTemplate = cancelDeliveryTemplate;
	}
	
	

	public SimpleMessageTemplateService() {
	}



	@Override
	public DeliveryTemplate getDeliveryTemplate() {
		return deliveryTemplate;
	}

	@Override
	public OrderCancelledTemplate getCancelTemplate() {
		return cancelDeliveryTemplate;
	}

}
