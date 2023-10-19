package Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Scanner;

public class Filesys {
    public Filesys(){
        try{
            file = new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
        }catch(Exception e){
            System.out.print("File does not exist.");
        }
    }

    public ArrayList<Patient> read() throws FileNotFoundException {
        ArrayList<Patient> patients = new ArrayList<>();
        Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String raw = sc.nextLine();
                Patient n = Patient.deserialize(raw.trim());
                patients.add(n);
            }
            sc.close();
        return patients;
    }

    public void write(ArrayList<Patient> patients){
        try{
            FileWriter writer = new FileWriter(file);
            for(Patient patient : patients){
                writer.write(patient.serialize());
            }
            writer.close();
        }catch(Exception e){
            System.out.print("Failed to update file.");
        }
    }

    File file;
    private final String path = "patient.data";
}
