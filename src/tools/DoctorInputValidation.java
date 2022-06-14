/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author minh tri
 */
public class DoctorInputValidation {

    private static Scanner sc = new Scanner(System.in);

    public static boolean checkDoctorId(String valid) {
        String regex = "DOC\\d{3}";
        if (valid.matches(regex) == false) {
            System.out.println("Invalid doc id");
        }else{
            System.out.println("valid doc id");
        }
        return valid.matches(regex);
    }

    public static boolean checkDoctorName(String valid) {
        String regex = "[a-zA-Z]{5,25}";
        if (valid.matches(regex) == false) {
            System.out.println("Invalid doc name");
        }else{
            System.out.println("valid doc name");
        }
        return valid.matches(regex);
    }

    public static boolean checkDoctorInputSex(String valid) {
        String regex = "true|false";
        if (valid.matches(regex) == false) {
            System.out.println("Invalid doc sex");
        }else{
            System.out.println("valid doc sex");
        }
        return valid.matches(regex);
    }

    public static boolean checkAddress(String valid) {
        String regex = ".{0,50}";
        if (valid.matches(regex) == false) {
            System.out.println("Invalid address");
        }else{
            System.out.println("valid doc address");
        }
        return valid.matches(regex);
    }

    public static String getDateCurrent() {
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(d);
    }

    public static String getString(String welcome) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input text!!!");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }
    
    public static String updateString(String welcome, String oldData) {
        String result = oldData;
        Scanner sc = new Scanner(System.in);
        System.out.print(welcome);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }

    public static int getInt(String welcome, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static boolean confirmYesNo(String welcome) {
        boolean result = false;
        String confirm = DoctorInputValidation.getString(welcome);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }

}
