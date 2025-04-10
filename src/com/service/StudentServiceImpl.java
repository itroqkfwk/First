package com.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.StudentDAO;
import com.dao.StudentGradeDAO;
import com.dto.StudentDTO;
import com.dto.StudentGradeDTO;

public class StudentServiceImpl implements StudentService {
	
	StudentDAO dao;
	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}
	
	StudentGradeDAO dao2;
	public void setDao2(StudentGradeDAO dao2) {
	    this.dao2 = dao2;
	}
	
	@Override
	public List<StudentDTO> findAll() {
		List<StudentDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			list = dao.findAll(session);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<StudentDTO> findName(String student_name) {
		List<StudentDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			list = dao.findName(session, student_name);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<StudentDTO> findYear(String startYear, String endYear) {
		List<StudentDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			list = dao.findYear(session, startYear, endYear);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<StudentDTO> findNo(List<String> student_no) {
	    List<StudentDTO> list = null;
	    SqlSession session = MySqlSessionFactory.getSession();
	    try {
	        list = dao.findNo(session, student_no);
	    } finally {
	        session.close();
	    }
	    return list;
	}

	@Override
	public int update(HashMap<String, Object> params) {
		int n = 0;
	    SqlSession session = MySqlSessionFactory.getSession();
	    try {
	    	n = dao.update(session, params);
			  session.commit();
		} finally {
			session.close();
		}
		return n;
	}
	
	@Override
	public int updateCapacity() {
	    SqlSession session = MySqlSessionFactory.getSession();
	    int updatedCount = 0;
	    try {
	        HashMap<String, Object> params2 = new HashMap<>();
	        updatedCount = dao.updateCapacity(session, params2);
	        session.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        session.rollback(); 
	    } finally {
	        session.close(); 
	    }
	    return updatedCount;
    }
	
	@Override
    public List<StudentGradeDTO> getStudentGrades(String studentNo) {
        List<StudentGradeDTO> grades = null;
        SqlSession session = MySqlSessionFactory.getSession();
        try {
            grades = dao2.getStudentGrades(session, studentNo); 
        } finally {
            session.close();
        }
        return grades;
    }

	@Override
	public List<StudentDTO> findPage(int pageSize, int offset) {
	    List<StudentDTO> list = null;
	    SqlSession session = MySqlSessionFactory.getSession();
	    try {
	        list = dao.findPage(session, pageSize, offset);
	    } finally {
	        session.close();
	    }
	    return list;
	}


	
}
