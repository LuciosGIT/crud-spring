package com.joselucio.crud_spring.enums;

public enum Category {

    BACK_END("Back-end"), FRONT_END("Front-end");

    private String value;

    private Category(String value) {
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
