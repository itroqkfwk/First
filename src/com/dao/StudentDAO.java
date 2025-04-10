package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.StudentDTO;

public class StudentDAO {
	
	public List<StudentDTO> findAll(SqlSession session){
		List<StudentDTO> list = session.selectList("com.config.EmpMapper.findAll");
		return list;
	}
	
	public List<StudentDTO> findName(SqlSession session, String student_name){
		List<StudentDTO> list = session.selectList("com.config.EmpMapper.findName", student_name);
		return list;
	}
	
	public List<StudentDTO> findYear(SqlSession session, String startYear, String endYear){
		Map<String, String> params = new HashMap<>();
		params.put("startYear", startYear);
		params.put("endYear", endYear);
		List<StudentDTO> list = session.selectList("com.config.EmpMapper.findYear", params);
		return list;
	}
	
	public List<StudentDTO> findNo(SqlSession session, List<String> studentNo) {
	    List<StudentDTO> list = session.selectList("com.config.EmpMapper.findNo", studentNo);
	    return list;
	}
	
	public int update(SqlSession session, HashMap<String, Object> params) {
		int n = session.update("com.config.EmpMapper.update", params);
		return n;
	}
	
	public int updateCapacity(SqlSession session, HashMap<String, Object> params2) {
	        return session.update("com.config.EmpMapper.updateCapacity", params2);
	}
	
	public List<StudentDTO> findPage(SqlSession session, int pageSize, int offset) {
	    return session.selectList("findPage", Map.of("pageSize", pageSize, "offset", offset));
	}
	
}
