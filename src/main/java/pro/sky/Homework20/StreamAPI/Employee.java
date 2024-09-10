package pro.sky.Homework20.StreamAPI;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String secondName;
    private int department;
    private int salary;


    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFIO() {
        return firstName + lastName + secondName;
    }

    public Employee(String firstName, String lastName, String secondName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(secondName, employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, secondName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", secondname='" + secondName + '\'' +
                '}';
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}
