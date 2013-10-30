//import org.apache.tuscany.sca.host.embedded.SCADomain;
package com.test.java;

//import java.util.HashMap;
//import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
//import org.activiti.engine.*;
//import com.interfaceWS.CalculatorInterface;
import com.test.output.InvokeWS;

public class invokeJava implements org.activiti.engine.delegate.JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		InvokeWS in = new InvokeWS();
		System.out.println("\n\n\n addR ");
		System.out.println("arg0:" + arg0);

//		Map<String, Object> a = new HashMap<String, Object>();

		int numA = Integer.parseInt(arg0.getVariable("num1").toString());
		int numB = Integer.parseInt(arg0.getVariable("num2").toString());
		System.out.println("num1 " + numA);
		System.out.println("num2 " + numB);
		
		
		// int numA = Integer.parseInt(rs.getVariables("num1").toString());
		// int numB = Integer.parseInt(rs.getVariables("num2").toString());
		double addAdd = in.add(numA, numB);
		arg0.setVariable("num4", (int)addAdd);
		System.out.println("\n\n\n addR " + addAdd);
	}
}
