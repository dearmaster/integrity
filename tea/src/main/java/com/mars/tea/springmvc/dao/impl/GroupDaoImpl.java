package com.mars.tea.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mars.tea.springmvc.dao.AbstractBaseDaoSupport;
import com.mars.tea.springmvc.dao.GroupDao;
import com.mars.tea.springmvc.enums.GroupTypeE;

@Repository("groupDao")
public class GroupDaoImpl extends AbstractBaseDaoSupport implements GroupDao {
	
	@Override
	public List<GroupTypeE> getGroups(String username) {
		List<GroupTypeE> list = new ArrayList<>();
		for(GroupTypeE type : GroupTypeE.values()) {
			list.add(type);
		}
		list.remove(GroupTypeE.SUPER_ADMIN);
		return list;
	}

}
