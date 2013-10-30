package com.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

@SuppressWarnings("serial")
public class SampleExecutionListener implements ExecutionListener {
	@Override
	public void notify(DelegateExecution delegateExecution) throws Exception {
		
		String proDefinitionId = delegateExecution.getProcessDefinitionId();
		String proInstanceId = delegateExecution.getProcessInstanceId();
		System.out.println("SampleExecutionListener: proDefinitionId "
				+ proDefinitionId);
		System.out.println("SampleExecutionListener: proInstanceId "
				+ proInstanceId);
	}
}
