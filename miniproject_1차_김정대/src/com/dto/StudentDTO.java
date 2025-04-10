package com.dto;

public class StudentDTO {
	private String stuNo;
	private String departNo;
	private String stuName;
	private String stussn;
	private String stuAddress;
	private String entDate;
	private char absyn;
	private String coachProfessorNo;
	
	public StudentDTO() {}
	
	public StudentDTO(String stuNo, String departNo, String stuName, String stussn, String stuAddress, String entDate,
			char absyn, String coachProfessorNo) {
		this.stuNo = stuNo;
		this.departNo = departNo;
		this.stuName = stuName;
		this.stussn = stussn;
		this.stuAddress = stuAddress;
		this.entDate = entDate;
		this.absyn = absyn;
		this.coachProfessorNo = coachProfessorNo;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getDepartNo() {
		return departNo;
	}

	public void setDepartNo(String departNo) {
		this.departNo = departNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStussn() {
		return stussn;
	}

	public void setStussn(String stussn) {
		this.stussn = stussn;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public String getEntDate() {
		return entDate;
	}

	public void setEntDate(String entDate) {
		this.entDate = entDate;
	}

	public char getAbsyn() {
		return absyn;
	}

	public void setAbsyn(char absyn) {
		this.absyn = absyn;
	}

	public String getCoachProfessorNo() {
		return coachProfessorNo;
	}

	public void setCoachProfessorNo(String coachProfessorNo) {
		this.coachProfessorNo = coachProfessorNo;
	}

	@Override
	public String toString() {
		return "StudentDTO [stuNo=" + stuNo + ", departNo=" + departNo + ", stuName=" + stuName + ", stussn=" + stussn
				+ ", stuAddress=" + stuAddress + ", entDate=" + entDate + ", absyn=" + absyn + ", coachProfessorNo="
				+ coachProfessorNo + "]";
	}
	
	
	
	
}
