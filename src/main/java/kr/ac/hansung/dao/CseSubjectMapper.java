package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.CseSubject;

public class CseSubjectMapper implements RowMapper<CseSubject> {

	
		@Override
		public CseSubject mapRow(ResultSet rs, int rowNum) throws SQLException {
			
		    CseSubject cseSubject = new CseSubject();
		 
		    cseSubject.setYear(rs.getInt("year"));
		    cseSubject.setSemester(rs.getInt("semester"));
		    cseSubject.setCode(rs.getString("code"));
		    cseSubject.setSubject(rs.getString("subject"));
		    cseSubject.setSection(rs.getString("section"));
		    cseSubject.setCredit(rs.getInt("credit"));
		    
		    return cseSubject;
		}
		
		
	}


