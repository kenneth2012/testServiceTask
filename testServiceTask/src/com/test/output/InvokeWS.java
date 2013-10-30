package com.test.output;

//import org.activiti.engine.delegate.DelegateExecution;
import org.apache.tuscany.sca.host.embedded.SCADomain;
import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Service;

import com.interfaceWS.CalculatorInterface;

@Service(com.interfaceWS.CalculatorInterface.class)
public class InvokeWS implements CalculatorInterface {

	private CalculatorInterface calWS;

	public InvokeWS() {
		SCADomain ws = SCADomain.newInstance("Calculator.composite");
		calWS = ws.getService(CalculatorInterface.class,
				"CalculatorServiceComponent");
		System.out.println("abc invokeWS。。。\n\n\n\n");
	}

	public CalculatorInterface getCalWS() {
		return calWS;
	}

	@Reference
	public void setCalWS(CalculatorInterface calWS) {
		this.calWS = calWS;
	}

	@Override
	public double add(double n1, double n2) {
		System.out.println("InvokeWs.java\n\n\n");
		return calWS.add(n1, n2);

	}

	@Override
	public double subtract(double n1, double n2) {
		return calWS.subtract(n1, n2);
	}

	@Override
	public double multiply(double n1, double n2) {
		return calWS.multiply(n1, n2);
	}

	@Override
	public double divide(double n1, double n2) {
		return calWS.divide(n1, n2);
	}

}
