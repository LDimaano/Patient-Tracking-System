import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Models.*;


public class TrackingSystem {
    void run(){
        try{
            datalist = filesys.read();
        }catch(FileNotFoundException fnfe){
            System.out.println("File not found");
        }
        while(true){
            switch(prompt()){
                case ADMIT:
                    admitPatient();
                break;
                case VIEW:
                    viewPatient();

                break;
                case UPDATE:
                    updatePatient();
                break;
                case DISCHARGE:
                    dischargePatient();
                break;
                case EXIT:
                    System.out.print("you are exiting");
                    System.exit(0);
            }
            filesys.write(datalist);
        }
    }

    int prompt(){
        System.out.println("\n      PATIENT TRACKING SYSTEM");
        System.out.println("+--------------------------------+");
        System.out.println("|\t1. Admit Patient         |");
        System.out.println("|\t2. View Patients         |");
        System.out.println("|\t3. Update Patient        |");
        System.out.println("|\t4. Discharge Patient     |");
        System.out.println("|\t5. Exit                  |");
        System.out.println("+--------------------------------+");    
        System.out.print("\n\tEnter Choice-> ");
        return Integer.parseInt(sc.nextLine());
    }

    void admitPatient(){
        Patient p = new Patient();
        p.Admit();
        datalist.add(p);
        System.out.println("\n    -->Patient is Admitted<--");
        System.out.println("+--------------------------------+");
    }

    void viewPatient(){         
        System.out.println();
        System.out.println("Patients admitted in the hospital:");
        int index = 0;
        for(Patient patient : datalist){
            patient.display(index++);
        }
    }

    void updatePatient(){
        viewPatient();
        System.out.println("+--------------------------------+");
        System.out.print("Enter the patient's number to edit: ");
        int index = Integer.parseInt(sc.nextLine());

        run_prompt(index);
        System.out.println("+--------------------------------+");
        System.out.println("\n -->Patient has been updated<--");
    }
    public void run_prompt(int index){
        switch(update_prompt()){
            case NAME:
                datalist.get(index).update_name();
            break;
            case ROOMNUM:
                datalist.get(index).update_roomnum();
            break;
            case STATUS:
                datalist.get(index).update_status();
            break;
            case DOCTOR:
                datalist.get(index).update_doctor();
            break;
            case EXIT:
                System.out.print("You are exiting...");
                System.exit(0);
        
    }
}
public int update_prompt(){
    System.out.println("\n\n+------Enter choice-----+");
    System.out.println("|1. Name                |");
    System.out.println("|2. Room num            |");
    System.out.println("|3. Status              |");
    System.out.println("|4. Doctor              |");
    System.out.println("|5. Exit                |");
    System.out.println("+-----------------------+");
    System.out.print("\n---> ");
    return Integer.parseInt(sc.nextLine());
}

    void dischargePatient(){
        viewPatient();
        System.out.println("+--------------------------------+");
        System.out.print("Enter the patient's index to be discharged: ");
        int index = Integer.parseInt(sc.nextLine());
        datalist.remove(index);
        System.out.println("\n -->Patient has been discharged<--");
        System.out.println("+--------------------------------+");
    }


    Filesys filesys = new Filesys();
    private ArrayList<Patient> datalist = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final int ADMIT = 1;
    private final int VIEW = 2;
    private final int UPDATE = 3;
    private final int DISCHARGE = 4;
    private final int EXIT = 5;
    private final int NAME = 1;
    private final int ROOMNUM = 2;
    private final int STATUS = 3;
    private final int DOCTOR = 4;
    private Patient p = new Patient();

    }

