package com.hwua.ManagementSystem.entity;

public class Department {

  private String DepartmentID;
  private String Department_name;
  
  
public String getDepartmentID() {
	return DepartmentID;
}
public void setDepartmentID(String departmentID) {
	DepartmentID = departmentID;
}
public String getDepartment_name() {
	return Department_name;
}
public void setDepartment_name(String department_name) {
	Department_name = department_name;
}
@Override
public String toString() {
	return "Department [DepartmentID=" + DepartmentID + ", Department_name=" + Department_name + "]";
}
  
}
