package com.acme.model;

public class Employee
{
    private String empName, empDesignation, reportingManager;
    
    public Employee() {}
    
    public Employee(String empName, String empDesignation, String reportingManager)
    {
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.reportingManager = reportingManager;
    }
    
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public String getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(String reportingManager) {
        this.reportingManager = reportingManager;
    }
}
