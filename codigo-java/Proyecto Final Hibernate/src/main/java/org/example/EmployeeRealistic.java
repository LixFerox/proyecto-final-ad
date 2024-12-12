package org.example;

import jakarta.persistence.*;

@Entity
@Table(name ="employees_realistic")
public class EmployeeRealistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "hire_date")
    private String hireDate;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "position")
    private String position;

    @Column(name = "employees_realistic_id")
    private int employeesRealisticId;

    public EmployeeRealistic() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getHireDate() {
        return hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public int getEmployeesRealisticId() {
        return employeesRealisticId;
    }
}
