package org.example;

import jakarta.persistence.*;

@Entity
@Table(name ="projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    public Projects() {
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public Double getBudget() {
        return budget;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
