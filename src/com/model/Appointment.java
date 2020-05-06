package com.model;

import java.sql.*;

public class Appointment {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/health","root","");
		}catch(Exception e) {
			e.printStackTrace();
		} return con;
	}
	
	//inserting appointment
	
	public String insertAppointment(String appointmentid,String doctorid,String doctorName,String patientid,String patientName,String hosName,String date) {
		String output = "";
		try {
			Connection con = connect();
			if(con == null) {
				return "Error while inserting into database";
			}
			
			//create prepared statement
			String query = "insert into appointment(appointmentid,doctorid,doctorname,patientid,patientname,hospitalname,date)" + "values(?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			preparedStmt.setString(1, appointmentid);
			preparedStmt.setString(2, doctorid);
			preparedStmt.setString(3, doctorName);
			preparedStmt.setString(4, patientid);
			preparedStmt.setString(5, patientName);
			preparedStmt.setString(6, hosName);
			preparedStmt.setString(7, date);
			
			//execute the statement
			preparedStmt.execute();
			con.close();
			String newAppoint = getAppointment();
			output = "{\"status\":\"success\", \"data\": \"" +newAppoint + "\"}";

			
		}catch(Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while inserting thepatient details.\"}";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	
	//read appointment
	public String getAppointment() {
		String output = "";
		try {
			Connection con = connect();
			if(con == null) {
				return "Error while connecting to the database for reading";
			}
			
			//prepare the html table
			output = "<table border=\"1\"><tr><th>Appointment ID</th><th>Doctor ID</th><th>Doctor Name</th><th>Patient ID</th><th>Patient Name</th><th>Hospital Name</th><th>Date</th><th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from appointment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			//duplicate the row
			while(rs.next()) {
				String pId = rs.getString("PID");
				String appointmentid = rs.getString("appointmentid");
				String doctorid = rs.getString("doctorid");
				String doctorname = rs.getString("doctorname");
				String patientid = rs.getString("patientid");
				String patientname = rs.getString("patientname");
				String hospitalname = rs.getString("hospitalname");
				String date = rs.getString("date");
				
				//add into the html table
				output += "<tr><td><input id='hidAppIDUpdate' name='hidAppIDUpdate' type='hidden' value='"+pId+"'>" + appointmentid + "</td>";
				
				
				output += "<td>" + doctorid + "</td>";
				output += "<td>" + doctorname + "</td>";
				output += "<td>" + patientid + "</td>";
				output += "<td>" + patientname + "</td>";
				output += "<td>" + hospitalname + "</td>";
				output += "<td>" + date + "</td>";
				
				
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-pid='"+pId+"'></td></tr>";

				
			}
			con.close();
			//complete the html table
			output += "</table>";
		}catch(Exception e) {
			output = "Error while reading the appointment.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	//update appointment
	public String updateAppointment(String pId,String appointmentid,String doctorid,String doctorname,String patientid,String patientname,String hospitalname,String date) {
		String output = "";
		try {
			Connection con = connect();
			if(con == null) {
				return "Error while connecting to the database for updating";
			}
			
			//create prepared statement
			String query = "update appointment set appointmentid=?,doctorid=?,doctorname=?,patientid=?,patientname=?,hospitalname=?,date=? where PID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding value
			preparedStmt.setString(1, appointmentid);
			preparedStmt.setString(2, doctorid);
			preparedStmt.setString(3, doctorname);
			preparedStmt.setString(4, patientid);
			preparedStmt.setString(5, patientname);
			preparedStmt.setString(6, hospitalname);
			preparedStmt.setString(7, date);
			preparedStmt.setInt(8, Integer.parseInt(pId));
		
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newApp = getAppointment();
			output = "{\"status\":\"success\", \"data\": \"" +newApp + "\"}";
			
		}catch(Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while updating the appointment.\"}";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	//delete update
	public String deleteAppointment(String pId) {
		String output = "";
		try {
			Connection con = connect();
			if(con == null) {
				return "Error while connecting to the database for deleting.";
			}
			
			//create prepare statement
			String query = "delete from appointment where pId=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding value
			preparedStmt.setInt(1, Integer.parseInt(pId));
			
			//execute
			preparedStmt.execute();
			con.close();
			String newApp = getAppointment();
			output = "{\"status\":\"success\", \"data\": \"" +newApp + "\"}";
		}catch(Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the appointment.\"}";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	
	
}
