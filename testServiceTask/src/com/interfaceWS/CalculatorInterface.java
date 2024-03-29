package com.interfaceWS;

import org.osoa.sca.annotations.Remotable;
//import org.osoa.sca.annotations.Service;

@Remotable
public interface CalculatorInterface {
    double add(double n1, double n2);
    double subtract(double n1, double n2);
    double multiply(double n1, double n2);
    double divide(double n1, double n2);
}
