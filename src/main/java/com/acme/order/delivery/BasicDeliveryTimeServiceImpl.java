package com.acme.order.delivery;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.order.Customer;
import com.acme.order.delivery.strategy.DeliveryTimeStrategy;
import com.acme.order.pizza.PizzaType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicDeliveryTimeServiceImpl implements DeliveryTimeService {

	@Autowired
	private TimeService timeService;
	@Autowired
	private DeliveryTimeStrategy strategy;

	public BasicDeliveryTimeServiceImpl() {
	}

	public BasicDeliveryTimeServiceImpl(TimeService timeService, DeliveryTimeStrategy strategy) {
		this.timeService = timeService;
		this.strategy = strategy;
	}

	@Override
	public Date getTime(Customer customer, PizzaType type) {
		
		log.info("BasicDeliveryTimeServiceImpl");
		log.info("Customer: {} PizzaType: {}", customer, type);
		int minutes = strategy.provideDeliveryMinutesOffset(customer, type);
		log.info("Minutes: {} ", minutes);
		Date now = timeService.now();

		return DateUtils.addMinutes(now, 5);
	}
}
