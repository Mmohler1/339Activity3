package com.gcu.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.OrdersBusinessService;


@Configuration
public class SpringConfig {

	@Bean(name="OrdersBusinessService")
	public OrdersBusinessInterface getOrdersBusiness()
	{
		return new OrdersBusinessService();
	}
}
