package org.example;

import jakarta.persistence.*;

@Entity
@Table(name ="employee_projects")
public class EmployeeProjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "hours_worked")
    private double hoursWorked;

    @Column(name = "employee_projects_id")
    private int employeeProjectsId;

    public EmployeeProjects() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public int getEmployeeProjectsId() {
        return employeeProjectsId;
    }
}
