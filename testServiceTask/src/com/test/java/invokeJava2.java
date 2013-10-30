//import org.apache.tuscany.sca.host.embedded.SCADomain;
package com.test.java;

//import java.util.HashMap;
//import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
//import org.activiti.engine.*;
//import com.interfaceWS.CalculatorInterface;
import com.test.output.InvokeWS;

public class invokeJava2 implements org.activiti.engine.delegate.JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		InvokeWS in = new InvokeWS();

		System.out
				.println("get num3 , num4 ......\n\n num3 "
						+ arg0.getVariable("num3") + "\n num4 "
						+ arg0.getVariable("num4"));
		double numC = Integer.parseInt(arg0.getVariable("num3").toString());
		double numD = (double)Integer.parseInt(arg0.getVariable("num4").toString());
		
		System.out.println("num3 " + numC);
		System.out.println("num4 " + numD);

		double addMul = in.multiply(numC, numD);
		System.out.println("\n\n\n addMul " + addMul);
	}
}
