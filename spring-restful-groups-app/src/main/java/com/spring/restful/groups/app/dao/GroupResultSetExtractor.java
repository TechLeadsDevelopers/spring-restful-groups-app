package com.spring.restful.groups.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.spring.restful.groups.app.model.Group;

public class GroupResultSetExtractor implements ResultSetExtractor<List<Group>> {

	@Override
	public List<Group> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Group> groups=new ArrayList<Group>();
		while(rs.next()) {
		Group group=new Group();
		group.setId(rs.getLong("ID"));
		group.setName(rs.getString("NAME"));
		group.setStatus(rs.getString("STATUS"));
		group.setDescription(rs.getString("DESCRIPTION"));
		group.setCreatdate(rs.getTimestamp("CREATDATE"));
		group.setLstmodified(rs.getTimestamp("LSTMODIFIED"));
		groups.add(group);
		}
		return groups;
	}

}
