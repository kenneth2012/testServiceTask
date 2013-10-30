package com.test.java;

//import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.junit.Test;

public class TestServiceTask2 {

	@Test
	public void test() {
//		ProcessEngine processEngine = ProcessEngineConfiguration
//				.createProcessEngineConfigurationFromResource(
//						"activiti.cfg.xml").buildProcessEngine();
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

		RepositoryService repositoryService = processEngine
				.getRepositoryService();
		String id = repositoryService.createDeployment()
				.addClasspathResource("testServiceTask2.bpmn").deploy()
				.getId();
		System.out.println("\n\n\n\n");
		System.out.println("id is " + id);
		System.out.println("\n\n\n\n");
		
		//implement (9+2)*6

		Map<String,Object> variables = new HashMap<String, Object>();
		variables.put("num1",10);
		variables.put("num2",3);
		variables.put("num3",6);

		RuntimeService runtimeService = processEngine.getRuntimeService();
		runtimeService.startProcessInstanceByKey("testServiceTask2",variables);
		
		System.out.println("\n\n TestServiceTask.java complete" );
	}
}
