package edu.gdut2.Test4;

public class Employee implements Comparable<Employee> {
    int id;

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Employee o) {
        if (this.id > o.id) {
            return 1;
        } else if (this.id == o.id) {
            return 0;
        } else {
            return -1;
        }
    }
}
