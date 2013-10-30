package com.test.output;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class OutputAAA implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
//		String group = (String) execution.getVariable("group");
//		System.out.println(group);
		
		System.out.println("\n\n\n\n");
		System.out.println("OutputAAA is running ");
		System.out.println("\n\n\n\n");
	}

}