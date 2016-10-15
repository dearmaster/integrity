package com.mars.tea.springmvc.dao;

import java.util.List;

import com.mars.tea.springmvc.enums.ElementTypeE;

public interface ElementDao {
	
	List<ElementTypeE> getEntitledElements(String username);

}
