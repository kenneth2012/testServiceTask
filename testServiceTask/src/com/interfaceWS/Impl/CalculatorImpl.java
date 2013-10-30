package com.interfaceWS.Impl;
import javax.jws.WebService;

import com.interfaceWS.Calculator;


@WebService(endpointInterface = "com.first.service.Calculator",
			serviceName = "calculator")
public class CalculatorImpl implements Calculator{

	@Override
	public int plus(int num1, int num2) {
		return num1+num2;
	}
}

public static void main(String[] args) {
		Calculator calculator;
		Server server;
		calculator = new CalculatorImpl();
	        JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
	        svrFactory.setServiceClass(Calculator.class);
	        svrFactory.setAddress("http://localhost:63081/calculator");
	        svrFactory.setServiceBean(calculator);
	        svrFactory.getInInterceptors().add(new LoggingInInterceptor());
	        svrFactory.getOutInterceptors().add(new LoggingOutInterceptor());
	        server = svrFactory.create();
	        server.start();
}
