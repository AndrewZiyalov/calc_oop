package com.company.calc.operation;

public class ConstOperation implements Operation {
    private final Number number;

    public ConstOperation(Number number) {
        this.number = number;
    }

    @Override
    public Number operate() {
        return number;
    }
}
