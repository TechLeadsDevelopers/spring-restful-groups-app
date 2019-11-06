package com.spring.restful.groups.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.restful.groups.app.model.Group;

public class GroupCustRowMapper<T> implements RowMapper<Group> {

	@Override
	public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
		Group group = new Group();
		group.setId(rs.getLong("ID"));
		group.setName(rs.getString("NAME"));
		group.setStatus(rs.getString("STATUS"));
		group.setDescription(rs.getString("DESCRIPTION"));
		group.setCreatdate(rs.getTimestamp("CREATDATE"));
		group.setLstmodified(rs.getTimestamp("LSTMODIFIED"));
		return group;
	}
}
