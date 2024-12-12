package org.example;

import jakarta.persistence.*;

@Entity
@Table(name ="departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "manager_id")
    private int managerId;

    public Departments() {
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getManagerId() {
        return managerId;
    }
}
