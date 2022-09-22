package com.quinnox.payrollServices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/payroll")
public class payrollResources {

	payrollRepository  repo = new payrollRepository();
		
		@GET
		@Path("details")
		@Produces(MediaType.APPLICATION_JSON) // gives array of parameters
		public List<payroll> getAllDetails() throws Exception
		{
			return repo.getAllDetails();
		}
		
		@POST
		@Path("insert")
		@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		//@Consumes(MediaType.APPLICATION_JSON)  // takes XML input from user.
		
		public payroll insertAccountDetail(payroll pr) throws Exception
		{
			repo.insertAccountDetail(pr);
			return 	pr;
		
		}
		@DELETE
		@Path("delete/{empid}")
		@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		public String  deleteAccount(@PathParam("empid")int empid) throws Exception
		{
			repo. deleteAccount(empid);
			return "Account = "+empid+" is deleled.";
		}
		@GET
		@Path("info/{empid}")
		@Produces( MediaType.APPLICATION_JSON)
		public List<payroll> getDetailtBasedOnId(@PathParam("empid")int empid) throws Exception
		{													//PathParam are path parameters of URL path
			return repo.getDetailtBasedOnId(empid);
			
		}
		@PUT
		@Path("update/{empid}")
		@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		//@Produces(MediaType.APPLICATION_XML)
		public List<payroll> updateEmployeeName(@PathParam("empid")int empid, payroll pr) throws Exception
		{	
			List<payroll> info = new ArrayList<payroll>();
			info.addAll(repo.getDetailtBasedOnId(empid));
			repo. updateEmployeeName(empid, pr);
			info.addAll(repo.getDetailtBasedOnId(empid));
			return info ;
		}
		
		
		}
		
		


