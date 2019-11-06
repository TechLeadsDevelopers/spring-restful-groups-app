package com.spring.restful.groups.app.dao;

import java.util.List;

import com.spring.restful.groups.app.model.Group;

public interface GroupDao {
	public int createGroup(Group group);
	public List<Group> getAllGroups();
	public Group getGroupById(Long id);
	public int updateGroupById(Group group, Long id);
	public int deleteGroupById(Long id);
	public int[] createGroupsBatch(List<Group> groups);
}
