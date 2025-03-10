package com.joselucio.crud_spring.enums;


public enum Status {

    ACTIVE("Ativo"), INACTIVE("Inativo");

    private String value;

    private Status(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

}
