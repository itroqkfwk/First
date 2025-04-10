package com.dto;

public class StudentGradeDTO {
	private String studentNo;
    private String studentName;
    private String className;
    private double point;
    private String grade;
    private String termNo;
    
	public StudentGradeDTO(String studentNo, String studentName, String className, double point, String grade,
			String termNo) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.className = className;
		this.point = point;
		this.grade = grade;
		this.termNo = termNo;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTermNo() {
		return termNo;
	}

	public void setTermNo(String termNo) {
		this.termNo = termNo;
	}

	@Override
	public String toString() {
		return "StudentGradeDTO [studentNo=" + studentNo + ", studentName=" + studentName + ", className=" + className
				+ ", point=" + point + ", grade=" + grade + ", termNo=" + termNo + "]";
	}
	
    
	
	
}
