/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author minh tri
 */
public class DepartmentInputValidation {

    public static boolean checkDepartmentId(String valid) {
        String regex = "DEP\\d{2}";
        if (valid.matches(regex) == false) {
            System.out.println("Invalid dep id");
        }else{
            System.out.println("valid dep id");
        }
        return valid.matches(regex);
    }

    public static boolean checkDepartmentName(String valid) {
        String regex = "[a-zA-Z0-9]{5,20}";
        if (valid.matches(regex) == false) {
            System.out.println("Invalid dep name");
        }else{
            System.out.println("valid dep name");
        }
        return valid.matches(regex);
    }

    public static String getDateCurrent() {
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(d);
    }

}
