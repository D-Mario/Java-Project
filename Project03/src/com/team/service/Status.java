package com.team.service;
/**
 * 表示员工的状态
 * @author Dario
 * @date 2020/6/6 17:03
 * @return 
 */

public class Status {
    private final String NAME;
    private Status(String name){
        this.NAME =  name;

    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
