package com.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class SampleLineListener implements JavaDelegate {

	@Override
	public void execute(DelegateExecution de) throws Exception {
		System.out.println("\nSamleLineListener.java is running\n");
	}
}
