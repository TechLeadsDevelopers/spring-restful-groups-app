package com.spring.restful.groups.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restful.groups.app.common.GroupURIs;
import com.spring.restful.groups.app.model.Group;
import com.spring.restful.groups.app.service.GroupService;

@RestController
public class GroupController {
	@Autowired
	private GroupService service;

	@RequestMapping(value = GroupURIs.GROUP_API_ROOT, method = RequestMethod.POST)
	public ResponseEntity<Group> createGroup(@RequestBody Group group) {
		group = service.createGroup(group);
		return new ResponseEntity<Group>(group, HttpStatus.CREATED);
	}

	@RequestMapping(value = GroupURIs.GROUP_API_ROOT_BATCH, method = RequestMethod.POST)
	public ResponseEntity<List<Group>> createGroupBatch(@RequestBody List<Group> groups) {
		groups=service.createGroupBatch(groups);
		return new ResponseEntity<List<Group>>(groups, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = GroupURIs.GROUP_API_ROOT, method = RequestMethod.GET)
	public ResponseEntity<List<Group>> getAllGroups() {
		List<Group> groups = service.getAllGroups();
		return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
	}

	@RequestMapping(value = GroupURIs.GROUP_API_URI_BY_ID, method = RequestMethod.GET)
	public ResponseEntity<Group> getRoleById(@PathVariable("id") String id) {
		Group group = service.getGroupById(Long.valueOf(id));
		return new ResponseEntity<Group>(group, HttpStatus.OK);
	}

	@RequestMapping(value = GroupURIs.GROUP_API_URI_BY_ID, method = RequestMethod.PUT)
	public ResponseEntity<Group> updateRoleById(@RequestBody Group group, @PathVariable("id") String id) {
		group = service.updateGroupById(group, Long.valueOf(id));
		group = service.getGroupById(Long.valueOf(id));
		return new ResponseEntity<Group>(group, HttpStatus.OK);
	}

	@RequestMapping(value = GroupURIs.GROUP_API_URI_BY_ID, method = RequestMethod.DELETE)
	public ResponseEntity<Group> deleteRoleById(@PathVariable("id") String id) {
		Group group = service.deleteGroupById(Long.valueOf(id));
		return new ResponseEntity<Group>(group, HttpStatus.GONE);
	}
}
