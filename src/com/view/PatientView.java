package com.view;

import com.model.Patient;
import com.services.PatientService;
import com.services.PatientServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientView {
    private static PatientService patientService=new PatientServiceImpl();
    private static Scanner scanner=new Scanner(System.in);

    // Add patient
    static void addPatient() {

        char flag='y';

        do {
            System.out.println("Enter Patient Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();

            System.out.println("Enter Patient Age: ");
            int age = scanner.nextInt();


            System.out.println("Enter Patient Gender: ");
            scanner.nextLine();
            String gender = scanner.nextLine();

            System.out.println("Enter Patient Address: ");
            String address = scanner.nextLine();

            System.out.println("Enter Patient Phone Number: ");
            String phoneNumber = scanner.nextLine();

            System.out.println("Enter Patient Email: ");
            String email = scanner.nextLine();

            patientService.addPatient(new Patient(0,name,age,gender,address,phoneNumber,email, LocalDate.now()));

            System.out.println("Do you wish to continue? (Y/N)");
            flag = scanner.next().charAt(0);
        }while (flag == 'y');
    }

    // Delete patient
    static  void deletePatient() {
        System.out.println("Enter Patient ID do you want to delete? ");
        patientService.deletePatient(scanner.nextInt());
    }

    // Get ALl patient
    static void getAllPatient() {

        List<Patient>  patients=patientService.getPatients();
        System.out.println(patients.toString());

    }

    //for update
    static  void updatePatient(){
        Patient patient=new Patient();
        System.out.println("Enter Patient ID do you want to update? ");
        int p_id = scanner.nextInt();

        System.out.println("Enter Patient Name: ");
        scanner.nextLine(); 
       patient.setName(scanner.nextLine());

        System.out.println("Enter Patient Age: ");
        patient.setAge(scanner.nextInt());

        scanner.nextLine();
        System.out.println("Enter Patient Gender: ");
        patient.setGender(scanner.nextLine());

        System.out.println("Enter Patient Address: ");
        patient.setAddress(scanner.nextLine());

        System.out.println("Enter Patient Phone Number: ");
        patient.setPhone(scanner.nextLine());

        System.out.println("Enter Patient Email: ");
        patient.setEmail(scanner.nextLine());

        patient.setApplicationDate(LocalDate.now());

        patientService.updatePatient(patient, p_id);

    }

    public static void main(String[] args) {


        // View  patient
        boolean flag=true;
        while(flag) {
            System.out.println("Enter your choice :");
            System.out.println("1. Add Patient");
            System.out.println("2. Delete Patient");
            System.out.println("3. Get all Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Exit");
            int choice=scanner.nextInt();
            switch(choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                   deletePatient();
                    break;
                case 3:
                   getAllPatient();
                    break;
                case 4:
                   updatePatient();
                    break;
                case 5:
                    System.out.println("Thank you for using our service");
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }

    }
}
