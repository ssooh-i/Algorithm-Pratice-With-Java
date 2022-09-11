package test.debug.person;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
	private String classId; //담당반 아이디
	private String licenseId; //교육자 아이디
	private static Teacher instance;
	
	private List<Teacher> teachar=new ArrayList<Teacher>();
	
	
	public static Person getInstance() {
		return instance;
	}
	
	public Teacher() {}
	public Teacher(String name, int age, String phone, String classId, String licenseId) {
		super(name, age, phone);
		setClassId(classId);
		setLicenseId(licenseId);
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String hospitalId) {
		this.classId = hospitalId;
	}
	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getClassId()).append("\t")
		  .append(getLicenseId());
		return sb.toString();
	}
}	
