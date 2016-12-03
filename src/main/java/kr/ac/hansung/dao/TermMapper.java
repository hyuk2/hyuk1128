package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import kr.ac.hansung.model.Term;

public class TermMapper  implements RowMapper<Term>{

	@Override
	public Term mapRow(ResultSet rs, int rowNum) throws SQLException {
		
        Term term = new Term();
	  
        term.setYear(rs.getInt("year"));
        term.setSemester(rs.getInt("semester"));
	
	    return term;
	}

}
