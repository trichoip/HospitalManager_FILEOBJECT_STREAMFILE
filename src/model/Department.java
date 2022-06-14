/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;



/**
 *
 * @author minh tri
 */
public class Department implements Serializable{
    // departmentID, name, createDate, lastUpdateDate
    private String departmentId; // DEPXX (X is digit)
    private String name; // from 5 to 20
    private String createDate;
    private String lastUpdateDate;

    public Department() {
    }

    public Department(String departmentId, String name, String createDate, String lastUpdateDate) {
        this.departmentId = departmentId;
        this.name = name;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentId=" + departmentId + ", name=" + name + ", createDate=" + createDate + ", lastUpdateDate=" + lastUpdateDate + '}';
    }

    
   
}
