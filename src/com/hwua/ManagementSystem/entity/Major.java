package com.hwua.ManagementSystem.entity;

public class Major {
	private String maid; //רҵ���
	private String major_name;//רҵ����
	private String DepartmentID;//ϵ�����
	private Department department;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getMaid() {
		return maid;
	}
	public void setMaid(String maid) {
		this.maid = maid;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public String getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(String departmentID) {
		DepartmentID = departmentID;
	}
	@Override
	public String toString() {
		return "Major [maid=" + maid + ", major_name=" + major_name + ", DepartmentID=" + DepartmentID + "]";
	}

	

}
