package com.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class SampleExecutionListenerEnd implements ExecutionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6471680398380037875L;

	@Override
	public void notify(DelegateExecution delegateExecution) throws Exception {
		System.out.println("\nprocess end ... \n");
	}
}
