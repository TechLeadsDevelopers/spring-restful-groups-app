package com.spring.restful.groups.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restful.groups.app.dao.GroupDao;
import com.spring.restful.groups.app.model.Group;

@Service
public class GroupServiceImpl implements GroupService {
	@Autowired
	private GroupDao dao;

	@Override
	public Group createGroup(Group group)  {
		int count = dao.createGroup(group);
		return group;
	}

	@Override
	public List<Group> getAllGroups()  {
		List<Group> groups =dao.getAllGroups();
		return groups;
	}

	@Override
	public Group getGroupById(Long id)  {
		Group group = dao.getGroupById(id);
		return group;
	}

	@Override
	public Group updateGroupById(Group group, Long id)  {
		int count=dao.updateGroupById(group, id);
		return group;
	}

	@Override
	public Group deleteGroupById(Long id)  {
		int count=dao.deleteGroupById(id);
		Group group=new Group();
		group.setId(id);
		return group;
	}

	@Override
	public List<Group> createGroupBatch(List<Group> groups)  {
		int count[]=dao.createGroupsBatch(groups);
		return groups;
	}

}
