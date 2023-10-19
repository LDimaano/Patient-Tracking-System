
package Models;

import java.util.Scanner;

public class Patient {
    public Patient(String p_name, String proom_num, String p_status, String p_doctor){ 
        name = p_name;
        room_num = proom_num;
        status = p_status;
        doctor = p_doctor;
    }

    public Patient(String nm, int rmn, String s, String dr){}

    public Patient() {
    }

    public void Admit(){
        System.out.println("\n" + "+--------------------------------+");
        System.out.print("Enter patient name: ");
        name = sc.nextLine();
        System.out.print("Enter room number: ");
        room_num = sc.nextLine();
        System.out.print("Enter status: ");
        status = sc.nextLine();
        System.out.print("Enter patient's doctor: ");
        doctor =sc.nextLine();
    } 

    public void display(int index){
        System.out.println("+--------------------------------+");
        System.out.print("["+index+"] ");
        System.out.println("Patient name:" + name);
        System.out.println("Room Number:"+ room_num); 
        System.out.println("Status:" + status);
        System.out.println("Doctor:" + doctor + "\n");
    }

    public void update_name(){
        System.out.print("\nEnter new patient name: ");
        name = sc.nextLine();
    }

    public void update_roomnum(){
        System.out.print("\nEnter new room number: ");
        room_num = sc.nextLine();
    }

    public void update_status(){
        System.out.print("\nEnter new patient status: ");
        status = sc.nextLine();
    }

    public void update_doctor(){
        System.out.print("\nEnter new patient doctor: ");
        doctor = sc.nextLine();
    }
    

    String serialize(){
        return name + "/ " + room_num + "/ " + status + "/ " + doctor + "\n";
    }
    
    public static Patient deserialize(String data){
        String[] raw = data.split("/");
        return new Patient(
            raw[0],
            raw[1],
            raw[2],
            raw[3]
        );
    }
    
    Scanner sc = new Scanner(System.in);
    private String name;
    private String room_num;
    private String status;
    private String doctor;
}
