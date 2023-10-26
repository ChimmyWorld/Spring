package com.itbank.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itbank.model.DTO.PersonDTO;

@Repository
public class Ex04DAO {
	
	@Autowired
	private JdbcTemplate jt;

	public String banner() {
		String sql = "select banner from v$version";
		return jt.queryForObject(sql, String.class);
	}

	public List<PersonDTO> selectAll() {
		String sql = "select * from person";
		
		RowMapper<PersonDTO> rowMapper = (ResultSet rs, int rowNum) -> {
			PersonDTO row = new PersonDTO();
			
			row.setBirth(rs.getDate("birth"));
			row.setHeight(rs.getDouble("height"));
			row.setName(rs.getString("name"));
			
			return row;
		};
		
		return jt.query(sql, rowMapper);
	}

}
