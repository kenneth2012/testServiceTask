package com.test.java;

//import static org.junit.Assert.*;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.TaskService;
//import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class StartListener {

	@Test
	public void test() {
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(
						"activiti.cfg.xml").buildProcessEngine();
		// ProcessEngine processEngine =
		// ProcessEngines.getDefaultProcessEngine();

		RepositoryService repositoryService = processEngine
				.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		TaskService taskService = processEngine.getTaskService();

		String id = repositoryService.createDeployment()
				.addClasspathResource("diagrams/listener.bpmn").deploy()
				.getId();
		System.out.println("\n");
		System.out.println("StartListener: deploymentId is " + id);
		System.out.println("\n");

		System.out.println("\nStartListener:startProcessInstance...\n");
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("listener");
		System.out.println("\nStartListener: end ProcessInstance...\n");

		String pId = pi.getProcessInstanceId();
		System.out.println("\n");
		System.out.println("StartListener: processInstanceId is " + pId);
		System.out.println("\n");

		List<Task> taskList = taskService.createTaskQuery()
				.taskCandidateUser("testCandidateUser").list();

		for (Task task : taskList) {
			taskService.claim(task.getId(), "testCandidateUser");
			taskService.complete(task.getId());
		}
	}
}
