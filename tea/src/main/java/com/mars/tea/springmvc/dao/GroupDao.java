package com.mars.tea.springmvc.dao;

import java.util.List;

import com.mars.tea.springmvc.enums.GroupTypeE;

public interface GroupDao {
	
	List<GroupTypeE> getGroups(String username);

}
