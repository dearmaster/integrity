package com.mars.tea.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mars.tea.springmvc.dao.GroupDao;
import com.mars.tea.springmvc.enums.GroupTypeE;
import com.mars.tea.springmvc.service.GroupService;

@Service("groupService")
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	@Qualifier("groupDao")
	private GroupDao groupDao;

	@Override
	public List<GroupTypeE> getGroups(String username) {
		return groupDao.getGroups(username);
	}
	
}
