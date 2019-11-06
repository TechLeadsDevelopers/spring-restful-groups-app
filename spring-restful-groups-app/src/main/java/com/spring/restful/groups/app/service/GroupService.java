package com.spring.restful.groups.app.service;

import java.util.List;

import com.spring.restful.groups.app.model.Group;

public interface GroupService {
	public Group createGroup(Group group);
	public List<Group> getAllGroups();
	public Group getGroupById(Long id);
	public Group updateGroupById(Group group, Long id);
	public Group deleteGroupById(Long id);
	public List<Group> createGroupBatch(List<Group> groups);
}
