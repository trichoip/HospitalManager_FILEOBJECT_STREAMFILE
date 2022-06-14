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
public class Doctor implements Serializable{
    //doctorID,	name, sex,	
    //address,	departmentID,	
    //createDate, lastUpdateDate

    private String doctorID; // DOCXXX (X: digit)
    private String name; // from 5 to 25
    private String sex; // True/False
    private String address; // from 0 to 50
    private String departmentID;// ref Department
    private String createDate; // ref document (dd/mm/yyyy)
    private String lastUpdate; // ref document (dd/mm/yyyy)

    public Doctor() {
    }

    public Doctor(String doctorID, String name, String sex, String address, String departmentID, String createDate, String lastUpdate) {
        this.doctorID = doctorID;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.departmentID = departmentID;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String isSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Doctor{" + "doctorID=" + doctorID + ", name=" + name + ", sex=" + sex + ", address=" + address + ", departmentID=" + departmentID + ", createDate=" + createDate + ", lastUpdate=" + lastUpdate + '}';
    }
}
