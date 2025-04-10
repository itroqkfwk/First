package com.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.dto.StudentGradeDTO;

public class StudentGradeDAO {
	public List<StudentGradeDTO> getStudentGrades(SqlSession session, String studentNo) {
        return session.selectList("com.config.EmpMapper.getStudentGrades", studentNo);
    }

}
