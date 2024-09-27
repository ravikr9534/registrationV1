package com.api;

public class Employee {
    private long id;
    private String Name;
    private int sal;
//Setters
    public Employee( long id,String name,int sal ) {
        this.sal = sal;
        this.id = id;
        Name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getSal() {
        return sal;
    }
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + Name + "', sal=" + sal + "}";
    }
}
