package com.spring.restful.groups.app.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.spring.restful.groups.app.model.Group;

public class GroupBatchSetter implements BatchPreparedStatementSetter {
	List<Group> groups;
	public GroupBatchSetter(List<Group> groups) {
		this.groups = groups;
	}
	
	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
		ps.setString(1, groups.get(i).getName());
		ps.setString(2, groups.get(i).getStatus());
		ps.setString(3, groups.get(i).getDescription());
		ps.setTimestamp(4, new java.sql.Timestamp(new Date().getTime()));
		ps.setTimestamp(5, new java.sql.Timestamp(new Date().getTime()));
	}
	@Override
	public int getBatchSize() {
		int batchSize=groups.size();
		return batchSize;
	}

}
