package com.company.calc;

import com.company.calc.operation.Operation;
import com.company.calc.parser.ParserOperation;

public class Calculator {

    private final ParserOperation parserOperation;

    public Calculator(ParserOperation parserOperation) {
        this.parserOperation = parserOperation;
    }

    public Number calculate(String ex) {
        Operation operation = parserOperation.parse(ex);
        return operation.operate();
    }
}
