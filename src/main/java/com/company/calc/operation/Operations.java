package com.company.calc.operation;

public abstract class Operations implements Operation {
    protected final Operation a;
    protected final Operation b;

    public Operations(Operation a, Operation b) {
        this.a = a;
        this.b = b;
    }

}
