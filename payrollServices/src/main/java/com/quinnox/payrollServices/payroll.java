package com.quinnox.payrollServices;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class payroll {
	private int empid;
	private String empolyeeName;
	private String designation;
	private int salary;
	
	public payroll(int empid, String empolyeeName, String designation, int salary) 
	{
		this.empid = empid;
		this.empolyeeName = empolyeeName;
		this.designation= designation;
		this.salary = salary;
	}
	public payroll(String employeeName) 
	{
		this.empolyeeName = employeeName;
	}
	
	public payroll() 
	{
	}

	public int getEmpid() 
	{
		return empid;
	}

	public void setEmpid(int empid) 
	{
		this.empid = empid;
	}

	//public String getEmployeeName()
	//{
		//return empolyeeName;
//	}

	//public void setEmpolyeeName( String employeeName) 
	//{
		//this.empolyeeName = employeeName;
	//}

	public String getDesignation() 
	{
		return designation;
	}

	public String getEmpolyeeName() {
		return empolyeeName;
	}
	public void setEmpolyeeName(String empolyeeName) {
		this.empolyeeName = empolyeeName;
	}
	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	public int getSalary() 
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "payroll [empid=" + empid + ", employeeName=" + empolyeeName + ", designation=" + designation
				+ ", salary=" + salary + "]";
	}

}
