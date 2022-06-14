/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import model.Doctor;
import tools.DoctorInputValidation;

/**
 *
 * @author minh tri
 */
public class DoctorRepository extends HashMap<String, Doctor> {

    public String inputIdDoc() {
        String id = "";
        boolean check = true;
        while (check) {
            id = DoctorInputValidation.getString("input id doc (DOCXXX) ").toUpperCase();
            if (DoctorInputValidation.checkDoctorId(id) == true) {

                check = false;

            }
        }
        return id;
    }

    public String inputNameDoc(String id) {
        String name = "";
        boolean check = true;
        if (this.containsKey(id) == true) {
            while (check) {
                name = DoctorInputValidation.updateString("input name{5,25} ", this.get(id).getName());
                if (DoctorInputValidation.checkDoctorName(name) == true) {

                    check = false;
                }
            }
        } else {
            while (check) {

                name = DoctorInputValidation.getString("input name{5,25} ");
                if (DoctorInputValidation.checkDoctorName(name) == true) {

                    check = false;
                }
            }
        }
        return name;
    }

    public String inputSexDoc(String id) {
        String sex = "";
        boolean check = true;
        if (this.containsKey(id) == true) {
            while (check) {
                sex = DoctorInputValidation.updateString("input sex true|false", this.get(id).isSex());
                if (DoctorInputValidation.checkDoctorInputSex(sex) == true) {

                    check = false;
                }
            }
        } else {
            while (check) {

                sex = DoctorInputValidation.getString("input sex true|false");
                if (DoctorInputValidation.checkDoctorInputSex(sex) == true) {

                    check = false;
                }
            }
        }
        return sex;
    }

    public String inputAddresDoc(String id) {
        String address = "";
        boolean check = true;
        if (this.containsKey(id) == true) {
            while (check) {
                address = DoctorInputValidation.updateString("input address {0,50}", this.get(id).isSex());
                if (DoctorInputValidation.checkAddress(address) == true) {

                    check = false;
                }
            }
        } else {
            while (check) {

                address = DoctorInputValidation.getString("input address {0,50}");
                if (DoctorInputValidation.checkAddress(address) == true) {

                    check = false;
                }
            }
        }
        return address;
    }

    public void readFromFile() throws IOException, ClassNotFoundException  {
        Doctor doctor;
        File file = new File("doctor.data");
        if (!file.exists()) {
            file.createNewFile();
        }

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (ois != null) {
                doctor = (Doctor) ois.readObject();
                System.out.println(doctor);
                this.put(doctor.getDoctorID(), doctor);
            }
            ois.close();
        } catch (IOException e) {
        
        }
    }

    public void writeToFile() throws IOException  {
        File file = new File("doctor.data");
        if (!file.exists()) {
            file.createNewFile();
        }

        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oss = new ObjectOutputStream(os);
            for (Doctor doctor : this.values()) {
                oss.writeObject(doctor);
            }
            oss.flush();
            oss.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
