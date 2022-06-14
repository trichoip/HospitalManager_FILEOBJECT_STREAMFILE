/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import java.io.IOException;
import model.Department;
import model.Doctor;
import repo.DepartmentRepository;
import repo.DoctorRepository;
import tools.DepartmentInputValidation;
import tools.DoctorInputValidation;

/**
 *
 * @author minh tri
 */
public class HospitaltBLL {

    DepartmentRepository deptList;
    DoctorRepository docList;

    public HospitaltBLL() throws IOException, ClassNotFoundException {
        deptList = new DepartmentRepository();
        docList = new DoctorRepository();
        deptList.readFromFile();
        docList.readFromFile();

    }

    public void showInputdeptRepo(String id) {

        System.out.println(deptList.get(id).toString());
    }

    public void showInputdocRepo(String id) {
        System.out.println(docList.get(id).toString());
    }

    public void addDoctor() throws IOException {
        boolean check = true;
        while (check) {
            String id = docList.inputIdDoc().toUpperCase();
            if (docList.containsKey(id) == true) {
                System.out.println("Duplicate!!!");
                check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
            } else {
                String name = docList.inputNameDoc(id);
                String sex = docList.inputSexDoc(id);
                String address = docList.inputAddresDoc(id);
                this.showAllDataDepartment();
                String deptID = deptList.inputDeptValid();
                String createDate = DoctorInputValidation.getDateCurrent();
                String lastUpdate = null;
                docList.put(id, new Doctor(id, name, sex, address, deptID, createDate, lastUpdate));
                this.showInputdocRepo(id);
                System.out.println("Add successfully!!!");
                docList.writeToFile();;
                check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
            }
        }

    }

    public void updateDoctor() throws IOException {
        boolean check = true;
        Doctor doctor;
        while (check) {
            this.showAllDataDoctor();
            String id = docList.inputIdDoc().toUpperCase();

            if (docList.containsKey(id) == true) {

                docList.get(id).setName(docList.inputNameDoc(id));
                docList.get(id).setSex(docList.inputSexDoc(id));

                docList.get(id).setAddress(docList.inputAddresDoc(id));

                docList.get(id).setDepartmentID(this.inputDeptValidUpdate(id));

                docList.get(id).setLastUpdate(DoctorInputValidation.getDateCurrent());
                this.showInputdocRepo(id);
                System.out.println("Update successfully!!!");
                docList.writeToFile();
                check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
            } else {
                System.out.println("Doctor does not exist!!!");
                check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
            }
        }
    }

    public String inputDeptValidUpdate(String id) {
        String dept = "";
        boolean check = true;
        while (check) {
            dept = DoctorInputValidation.updateString("Input department ID: ", docList.get(id).getDepartmentID()).toUpperCase();
            if (deptList.containsKey(dept) == true) {
                check = false;
            } else {
                System.out.println("Department does not exist!!!");

            }
        }
        return dept;
    }

    public void deleteDoctor() throws IOException {
        boolean check = true;
        while (check) {
            this.showAllDataDoctor();
            String id = docList.inputIdDoc().toUpperCase();
            if (docList.containsKey(id) == true) {
                this.showInputdocRepo(id);
                boolean comfirmDelete = DoctorInputValidation.confirmYesNo("Do you want remote it(Y/N)? ");
                if (comfirmDelete == true) {
                    docList.remove(id);
                    docList.writeToFile();

                    System.out.println("Remote successfully!!!");
                    check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
                } else {
                    System.out.println("Remote failed!!!");
                    check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
                }

            } else {
                System.out.println("Doctor does not exist!!!");
                check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
            }
        }

    }

    public void addDepartment() throws IOException {
        boolean check = true;
        while (check) {
            String id = deptList.inputIdDept().toUpperCase();
            if (deptList.containsKey(id) == true) {
                System.out.println("Duplicate!!!");
                check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
            } else {

                String name = deptList.inputNamedept(id);
                String createDate = DepartmentInputValidation.getDateCurrent();
                String lastUpdate = null;
                deptList.put(id, new Department(id, name, createDate, lastUpdate));
                this.showInputdeptRepo(id);
                System.out.println("Add successfully!!!");
                deptList.writeToFile();
                check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");

            }
        }
    }

    public void updateDepartment() throws IOException {
        boolean check = true;
        while (check) {
            this.showAllDataDepartment();
            String id = deptList.inputIdDept().toUpperCase();
            if (deptList.containsKey(id) == true) {

                deptList.get(id).setName(deptList.inputNamedept(id));
                deptList.get(id).setCreateDate(deptList.get(id).getCreateDate());
                deptList.get(id).setLastUpdateDate(DepartmentInputValidation.getDateCurrent());

                System.out.println("Update successfully!!!");
                this.showInputdeptRepo(id);
                deptList.writeToFile();
                check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
            } else {
                System.out.println("Department does not exist!!!");
                check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
            }
        }
    }

// DELETE DEPARTMENT
    public void deleteDepartment() throws IOException {
        boolean check = true;
        while (check) {
            this.showAllDataDepartment();
            String id = deptList.inputIdDept().toUpperCase();
            if (deptList.containsKey(id) == true) {
                if (this.checkDeptIdInDoctorList(id) == true) {
                    System.out.println("Doctor already exists in this department so it cannot be deleted!!!");
                    check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
                } else {
                    this.showInputdeptRepo(id);
                    boolean comfirmDelete = DoctorInputValidation.confirmYesNo("Do you want remote it(Y/N)? ");
                    if (comfirmDelete == true) {
                        deptList.remove(id);
                        deptList.writeToFile();
                        System.out.println("Remote successfully!!!");
                        check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
                    } else {
                        System.out.println("Remote failed!!!");
                        check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
                    }

                }

            } else {
                System.out.println("Department does not exist!!!");
                check = DoctorInputValidation.confirmYesNo("Do you want to continue(Y/N)? ");
            }
        }
    }

    // CHECK DEPARTMENT IN DOCTOR LIST
    public boolean checkDeptIdInDoctorList(String id) {
        boolean check = false;
        for (Doctor value : docList.values()) {
            if (value.getDepartmentID().equalsIgnoreCase(id) == true) {
                check = true;
            }
        }
        return check;
    }

    public void showAllDataDepartment() {
        if (deptList.isEmpty() == true) {
            System.out.println("List empty!!!");
        } else {

            for (Department value : deptList.values()) {
                System.out.println(value.toString());
            }

        }
    }

    public void showAllDataDoctor() {
        if (docList.isEmpty() == true) {
            System.out.println("List empty!!!");
        } else {

            for (Doctor value : docList.values()) {
                System.out.println(value.toString());
            }

        }
    }

    public void searchDepartmentByID() {
        boolean check = true;
        String id = deptList.inputIdDept().toUpperCase();

        if (deptList.containsKey(id) == true) {
            for (Department value : deptList.values()) {
                if (value.getDepartmentId().equalsIgnoreCase(id) == true) {
                    System.out.println(value.toString());
                }
            }
        } else {
            System.out.println("invalid dep id");

        }

    }

    // SEARCH NAME DOCTOR
    public void searchDoctorByName() {
        boolean check = true;
        String name = DoctorInputValidation.getString("Input name doctor: ");

        for (Doctor value : docList.values()) {
            if (value.getName().contains(name) == true) {
                System.out.println(value.toString());
            }
        }

    }

 
    public void storeAllDateToFile() throws IOException {
        docList.writeToFile();
        System.out.println("Store list doctor successfully!!!");
        deptList.writeToFile();
        System.out.println("Store list department successfully!!!");

    }

}
