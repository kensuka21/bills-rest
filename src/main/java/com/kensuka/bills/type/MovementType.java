package com.kensuka.bills.type;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kmukai on 10/7/2016.
 */
public enum MovementType {
    INCOME("Income"),
    EXPENSE("Expense");

    private String description;
    public static Map<Integer, String> map = new HashMap<>();

    MovementType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
