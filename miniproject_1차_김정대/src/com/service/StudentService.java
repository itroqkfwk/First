package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.dao.StudentDAO;
import com.dao.StudentGradeDAO;
import com.dto.StudentDTO;
import com.dto.StudentGradeDTO;

public interface StudentService {
	
	public abstract void setDao(StudentDAO dao);
	public abstract void setDao2(StudentGradeDAO dao2);
	public abstract List<StudentDTO> findAll();
	public abstract List<StudentDTO> findName(String student_name);
	public abstract List<StudentDTO> findYear(String startYear, String endYear);
	public abstract List<StudentDTO> findNo(List<String> student_no);
	public abstract int update(HashMap<String, Object> params);
	public abstract int updateCapacity();
	public abstract List<StudentGradeDTO> getStudentGrades(String studentNo);
	public abstract List<StudentDTO> findPage(int pageSize, int offset);
}
