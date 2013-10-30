package com.test.java;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class JavaListener implements JavaDelegate {

	@Override
	public void execute(DelegateExecution delegateExcution) throws Exception {
		String processInstanceId = delegateExcution.getProcessInstanceId();
		System.out.println("processInstanceId : " + processInstanceId);
	}
}
