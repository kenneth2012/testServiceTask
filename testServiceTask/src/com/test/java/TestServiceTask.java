package com.test.java;

//import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.junit.Test;

public class TestServiceTask {

	@Test
	public void test() {
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(
						"activiti.cfg.xml").buildProcessEngine();
//		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

		RepositoryService repositoryService = processEngine
				.getRepositoryService();
		String id = repositoryService.createDeployment()
				.addClasspathResource("testServiceTask.bpmn").deploy()
				.getId();
		System.out.println("\n\n\n\n");
		System.out.println("id is " + id);
		System.out.println("\n\n\n\n");

		Map<String,Object> variables = new HashMap<String, Object>();
		variables.put("num1",9);
		variables.put("num2",2);
		
		RuntimeService runtimeService = processEngine.getRuntimeService();
		runtimeService.startProcessInstanceByKey("testServiceTask",variables);
		
		System.out.println("\n\n TestServiceTask.java complete" );
	}
}
