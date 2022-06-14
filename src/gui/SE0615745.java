/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import bus.HospitaltBLL;
import java.io.IOException;

/**
 *
 * @author minh tri
 */
public class SE0615745 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        HospitaltBLL hosBLL = new HospitaltBLL();

        Menu mainMenu = new Menu();
        mainMenu.addItem("1. Show information");
        mainMenu.addItem("2. Add new");
        mainMenu.addItem("3. Update information");
        mainMenu.addItem("4. Delete              ");
        mainMenu.addItem("5. Search information");
        mainMenu.addItem("6. Store data to file");
        mainMenu.addItem("Others. Quit");

        boolean check = true;
        int choice;

        while (check) {
            mainMenu.showMenu();
            choice = mainMenu.getChoice();
            switch (choice) {

                case 1:
                    Menu menuShowInfor = new Menu();
                    menuShowInfor.addItem("1. Show doctor list");
                    menuShowInfor.addItem("2. Show department list");
                    menuShowInfor.showMenu();
                    choice = menuShowInfor.getChoice();
                    switch (choice) {
                        case 1:
                            hosBLL.showAllDataDoctor();
                            break;
                        case 2:
                            hosBLL.showAllDataDepartment();
                            break;
                    }
                    break;

                case 2:
                    Menu menuAdd = new Menu();
                    menuAdd.addItem("1. Add new doctor");
                    menuAdd.addItem("2. Add new department");
                    menuAdd.showMenu();
                    choice = menuAdd.getChoice();
                    switch (choice) {
                        case 1:
                            hosBLL.addDoctor();
                            break;
                        case 2:
                            hosBLL.addDepartment();
                            break;
                    }
                    break;

                case 3:
                    Menu menuUpdate = new Menu();
                    menuUpdate.addItem("1. Update doctor");
                    menuUpdate.addItem("2. Update department");
                    menuUpdate.showMenu();
                    choice = menuUpdate.getChoice();
                    switch (choice) {
                        case 1:
                            hosBLL.updateDoctor();
                            break;
                        case 2:
                            hosBLL.updateDepartment();
                            break;
                    }
                    break;

                case 4:
                    Menu menuDelete = new Menu();
                    menuDelete.addItem("1. Delete doctor");
                    menuDelete.addItem("2. Delete department");
                    menuDelete.showMenu();
                    choice = menuDelete.getChoice();
                    switch (choice) {
                        case 1:
                            hosBLL.deleteDoctor();
                            break;
                        case 2:
                            hosBLL.deleteDepartment();
                            break;
                    }
                    break;

                case 5:
                    Menu menuSearchInfor = new Menu();
                    menuSearchInfor.addItem("1. Search doctor by name");
                    menuSearchInfor.addItem("2. Search department by ID");
                    menuSearchInfor.showMenu();
                    choice = menuSearchInfor.getChoice();
                    switch (choice) {
                        case 1:
                            hosBLL.searchDoctorByName();
                            break;
                        case 2:
                            hosBLL.searchDepartmentByID();
                            break;
                    }
                    break;

                case 6:
                    hosBLL.storeAllDateToFile();
                    break;
                default:

                    check = false;

            }
        }
    }
}
