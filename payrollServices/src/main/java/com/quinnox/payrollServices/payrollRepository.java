package com.quinnox.payrollServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class payrollRepository {
	public List<payroll> getAllDetails() throws Exception
	{
		
		 Connection con = DatabaseConnectivity.getConnection();
		 String query = "SELECT * FROM payrolldetail";
		 Statement st =  con.createStatement();
		 ResultSet rs =  st.executeQuery(query);
		 
		 List<payroll> info = new ArrayList<payroll>();
		 
		 while(rs.next())
		 {
			 payroll pr = new payroll();
			 
			 pr.setEmpid(rs.getInt("empid"));
			 pr.setEmpolyeeName(rs.getString("empolyeeName"));
			 pr.setDesignation(rs.getString("designation"));
			 pr.setSalary(rs.getInt("salary"));
			 
			 info.add(pr);

		 }
			
		return info;	
	}
	public void  insertAccountDetail(payroll pr) throws Exception

	{
		Connection con = DatabaseConnectivity.getConnection();
		String insertStmt = "INSERT INTO payrolldetail VALUES(?, ?, ?, ?)";
		PreparedStatement ps =  con.prepareStatement(insertStmt);
		
		ps.setInt(1, pr.getEmpid());
		ps.setString(2, pr.getEmpolyeeName());
		ps.setString(3, pr.getDesignation());
		ps.setInt(4, pr.getSalary());
		
		ps.executeUpdate();

	}
	
	public String  deleteAccount(int empid) throws Exception
	{
		Connection con = DatabaseConnectivity.getConnection();		
		String queryUpdate = "delete from payrolldetail where empid = "+empid;
		PreparedStatement ps =  con.prepareStatement(queryUpdate);
		ps.executeUpdate();

		return "Deleted";
	}
	public List<payroll> getDetailtBasedOnId(int empid) throws Exception
	{
		Connection con = DatabaseConnectivity.getConnection();
		String query =  "Select * From payrolldetail WHERE empid ="+empid;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<payroll> info = new ArrayList<payroll>();

		
		while(rs.next())
		 {
			payroll pr = new payroll();
			pr.setEmpid(rs.getInt("empid"));
			pr.setEmpolyeeName(rs.getString("empolyeeName"));
			pr.setDesignation(rs.getString("designation"));
			pr.setSalary(rs.getInt("salary"));
			
			 info.add(pr);
			 
		 }
			
		return info;	
	}
	public void  updateEmployeeName(int empid, payroll pr) throws Exception
	{
		Connection con = DatabaseConnectivity.getConnection();		
		String queryUpdate = "update payrolldetail set empolyeeName = ? where empid= ?";
		PreparedStatement ps =  con.prepareStatement(queryUpdate);
		ps.setString(1, pr.getEmpolyeeName());
		ps.setInt(2, empid);
		ps.executeUpdate();

	}
	
}
