package com.company.calc.parser;

import com.company.calc.operation.*;

import java.util.ArrayList;

public class ParserOperation {
    public Operation parse(String ex) throws ClassCastException {
        //все символы в объект с распределением по типам чтоб в зависимости от типа числа был ответ типом int или double
        ArrayList<Object> objects = new ParserObjects().parse(ex);
        //результат инициалзируем первым числом. Минимум два числа и одна операция
        Operation result = new ConstOperation((Number)objects.get(0));
        for (int i = 1; i < objects.size(); i += 2) {
            Object secondNum = objects.get(i+1);
            if (secondNum instanceof Number) {
                if (objects.get(i).equals("+")) {
                    result = new SumOperations(result, (Number) secondNum);
                } else if (objects.get(i).equals("-")) {
                    result = new SubOperations(result, (Number) secondNum);
                } else if (objects.get(i).equals("*")) {
                    result = new MultiplyOperations(result, (Number) secondNum);
                } else if (objects.get(i).equals("/")) {
                    result = new DivOperations(result, (Number) secondNum);
                }
            }
            else { throw new ClassCastException("Неверное выражение");}
        }
        return result;
    }
}
