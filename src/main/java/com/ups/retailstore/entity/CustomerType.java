package com.ups.retailstore.entity;


public enum CustomerType {
    EMPLOYEE(1, 30),
    AFFILIATE(2, 10),
    OLD_CUSTOMER(3, 5);

    private final int typeId;

    public int getDiscPercentage() {
        return discPercentage;
    }

    private final int discPercentage;

    CustomerType(Integer type, Integer discPercentage) {
        this.typeId = type;
        this.discPercentage = discPercentage;
    }
}
