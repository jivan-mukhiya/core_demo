package com.services;

import com.db.DbConnection;
import com.model.Patient;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements PatientService{

    @Override
    public void addPatient(Patient patient) {
       String sql="insert into patient(name,age,gender,address,phone,email,applicationDate) " +
               "values(?,?,?,?,?,?,?)";
       try{
           PreparedStatement preparedStatement= DbConnection.getConnection().prepareStatement(sql);
           preparedStatement.setString(1,patient.getName());
           preparedStatement.setInt(2,patient.getAge());
           preparedStatement.setString(3,patient.getGender());
           preparedStatement.setString(4,patient.getAddress());
           preparedStatement.setString(5,patient.getPhone());
           preparedStatement.setString(6,patient.getEmail());
           preparedStatement.setDate(7, Date.valueOf(patient.getApplicationDate()));
           preparedStatement.executeUpdate();
           System.out.println("Patient added successfully");
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Override
    public void deletePatient(int id) {

        String sql="delete from patient where id=?";

        try {
            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Patient deleted successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Patient> getPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql="select * from patient";
        try{
           Statement statement = DbConnection.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){

                    patients.add(new Patient(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getString("gender"),
                            resultSet.getString("address"),
                            resultSet.getString("phone"),
                            resultSet.getString("email"),
                            resultSet.getDate("applicationDate").toLocalDate()
                            ));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public void updatePatient(Patient patient, int P_id) {
            String sql ="Update patient SET name=?,age=?,gender=?,address=?,phone=?,email=?,applicationDate=? Where id=?";

            try{
                PreparedStatement preparedStatement=DbConnection.getConnection().prepareStatement(sql);
                preparedStatement.setString(1,patient.getName());
                preparedStatement.setInt(2,patient.getAge());
                preparedStatement.setString(3,patient.getGender());
                preparedStatement.setString(4,patient.getAddress());
                preparedStatement.setString(5,patient.getPhone());
                preparedStatement.setString(6,patient.getEmail());
                preparedStatement.setDate(7,Date.valueOf(patient.getApplicationDate()));
                preparedStatement.setInt(8,P_id);
                preparedStatement.executeUpdate();
                System.out.println("Patient updated successfully");
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
