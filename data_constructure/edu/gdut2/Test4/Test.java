package edu.gdut2.Test4;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Employee e1 = new Employee(1);
        Employee e2 = new Employee(2);
        Employee e3 = new Employee(3);
        Employee e4 = new Employee(4);
        Employee e5 = new Employee(5);
        Employee e6 = new Employee(6);
        Employee e7 = new Employee(7);
        Employee e8 = new Employee(8);
        Employee e9 = new Employee(9);
        Employee e10 = new Employee(10);
        TreeSet<Employee> set = new TreeSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);
        set.add(e7);
        set.add(e8);
        set.add(e9);
        set.add(e10);
        for (Employee employee : set) {
            System.out.println(employee.id);
        }
    }
}
