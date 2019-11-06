package com.spring.restful.groups.app.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.restful.groups.app.common.DbQueries;
import com.spring.restful.groups.app.model.Group;

@Repository
public class GroupDaoImpl implements GroupDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int createGroup(Group group)  {
		int count = 0;
		Object[] params = { 
				group.getName(), 
				group.getStatus(), 
				group.getDescription(),
				new java.sql.Timestamp(new Date().getTime()),
				new java.sql.Timestamp(new Date().getTime())
				};
		count = jdbcTemplate.update(DbQueries.INSERT_GROUPS, params);
		return count;
	}

	@Override
	public List<Group> getAllGroups()  {
		List<Group> groups = jdbcTemplate.query(DbQueries.GET_ALL_GROUPS, new GroupResultSetExtractor());
		return groups;
	}

	@Override
	public Group getGroupById(Long id)  {
		Group group = jdbcTemplate.queryForObject(DbQueries.GET_GROUP_BY_ID, new GroupCustRowMapper<Group>(),id);
		return group;
	}

	@Override
	public int updateGroupById(Group group, Long id)  {
		Object[] params = { 
				group.getName(), 
				group.getStatus(), 
				group.getDescription(),
				new java.sql.Timestamp(new Date().getTime()),
				id };
		int count = jdbcTemplate.update(DbQueries.UPDATE_GROUP_BY_ID, params);
		return count;
	}

	@Override
	public int deleteGroupById(Long id)  {
		Object[] params = { id };
		int count = jdbcTemplate.update(DbQueries.DELETE_GROUP_BY_ID, params);
		return count;
	}

	@Override
	public int[] createGroupsBatch(List<Group> groups)  {
		int count[]=jdbcTemplate.batchUpdate(DbQueries.INSERT_GROUPS, new GroupBatchSetter(groups));
		return count;
	}

}
