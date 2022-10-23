package com.company.calc.operation;

import java.text.DecimalFormat;

public class DivOperations extends Operations {

    public DivOperations(Operation a, Number b) throws ArithmeticException {
        super(a, new ConstOperation(b));
    }

    /*
    Операция деления, возвращает результат деления чисел в зависимости от типа чисел. Для целых чисел не больше типа int
    для дробных не больше float. Если результат деления целых чисел дробное число, то результатом работы функции так же дробное число
     */
    private Number getResult(Number a, Number b) {
        DecimalFormat df = new DecimalFormat("#.####");
        try {
            if (a instanceof Double || b instanceof Double) {
                return new Double(df.format(a.doubleValue() / b.doubleValue()).replace(',','.'));
            } else {
                if ((((double) a.intValue() / (double) b.intValue()) - (double)(a.intValue()/b.intValue())) > 0) {
                    return new Double(df.format(a.doubleValue() / b.doubleValue()).replace(',','.'));
                } else return a.intValue() / b.intValue();
            }
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Деление на ноль");
        }
    }

    @Override
    public Number operate() {
        return getResult(a.operate(), b.operate());
    }
}
