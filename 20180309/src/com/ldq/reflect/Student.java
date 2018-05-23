package com.ldq.reflect;

import java.util.Date;

import com.entor.reflect.Table;

@Table("stu_inf")
public class Student {
	@Column("sno")
	private int sno;
	@Column("name")
	private String name;
	@Column("birth")
	private Date birth;
	@Column("admission_date")
	private Date admissionDate;
	private String note;
	public Student() {
	}
	public Student(int sno, String name, Date birth, Date admissionDate, String note) {
		super();
		this.sno = sno;
		this.name = name;
		this.birth = birth;
		this.admissionDate = admissionDate;
		this.note = note;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
