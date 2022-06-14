/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.StringTokenizer;
import model.Department;
import model.Doctor;
import tools.DepartmentInputValidation;
import tools.DoctorInputValidation;

/**
 *
 * @author minh tri
 */
public class DepartmentRepository extends HashMap<String, Department> {

    public String inputIdDept() {
        String id = "";
        boolean check = true;
        while (check) {
            id = DoctorInputValidation.getString("input id dept(DEPXX) ").toUpperCase();

            if (DepartmentInputValidation.checkDepartmentId(id) == true) {

                check = false;

            }
        }
        return id;
    }

    public String inputNamedept(String id) {
        String name = "";
        boolean check = true;
        if (this.containsKey(id) == true) {
            while (check) {
                name = DoctorInputValidation.updateString("input name (5,20)", this.get(id).getName());
                if (DepartmentInputValidation.checkDepartmentName(name) == true) {

                    check = false;
                }
            }
        } else {
            while (check) {

                name = DoctorInputValidation.getString("input name (5,20)");
                if (DepartmentInputValidation.checkDepartmentName(name) == true) {

                    check = false;
                }
            }
        }
        return name;
    }

    public String inputDeptValid() {
        String dept = "";
        boolean check = true;
        while (check) {
            dept = this.inputIdDept().toUpperCase();
            if (this.containsKey(dept) == true) {
                System.out.println("valid dep id");
                check = false;
            } else {
                System.out.println("invalid dep id");

            }
        }
        return dept;
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        Department department;
        File file = new File("department.data");
        if (!file.exists()) {
            file.createNewFile();
        }

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (ois != null) {
                department = (Department) ois.readObject();
                System.out.println(department);
                this.put(department.getDepartmentId(), department);
            }
            ois.close();
        } catch (IOException e) {

        }
    }

    public void writeToFile() throws IOException {
        File file = new File("department.data");
        if (!file.exists()) {
            file.createNewFile();
        }

        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oss = new ObjectOutputStream(os);
            for (Department department : this.values()) {
                oss.writeObject(department);
            }
            oss.flush();
            oss.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
