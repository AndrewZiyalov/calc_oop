package com.company.calc.operation;

import java.text.DecimalFormat;

public class MultiplyOperations extends Operations {

    /*
    Операция умножения, возвращает результат умножения чисел в зависимости от типа чисел. Для целых чисел не больше типа int
    для дробных не больше float
     */
    public MultiplyOperations(Operation a, Number b) {
        super(a, new ConstOperation(b));
    }

    private Number getResult(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            DecimalFormat df = new DecimalFormat("#.####");
            return new Double(df.format(a.doubleValue() * b.doubleValue()).replace(',','.'));
        } else return a.intValue() * b.intValue();
    }

    @Override
    public Number operate() {
        return getResult(a.operate(), b.operate());
    }
}