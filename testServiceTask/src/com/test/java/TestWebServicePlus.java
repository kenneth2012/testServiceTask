package com.test.java;

public class TestWebServicePlus {
	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("acitiviti.cfg.xml");
	RepositoryService repositoryService=(RepositoryService) applicationContext.getBean("repositoryService");
	RuntimeService runtimeService  = (RuntimeService) applicationContext.getBean("runtimeService");
	IdentityService identityService=(IdentityService) applicationContext.getBean("identityService");
	repositoryService.createDeployment().addClasspathResource("calculator.bpmn20.xml").deploy();
	
	Map<String,Object> map=new HashMap<String,Object>();
	map.put("input1", 2); 
	map.put("input2", 3);
	ProcessInstance pi=runtimeService.startProcessInstanceByKey("process1", map);
	System.out.println(pi.getId());
	
	
	TaskService taskService = (TaskService) applicationContext.getBean("taskService");
	taskService.claim("12", "yuyong");
	taskService.complete("12");
	int output = (Integer) runtimeService.getVariable("5", "output3");
	System.out.println(output);
}
