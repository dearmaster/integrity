package com.mars.tea.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mars.tea.springmvc.dao.AbstractBaseDaoSupport;
import com.mars.tea.springmvc.dao.ElementDao;
import com.mars.tea.springmvc.enums.ElementTypeE;

@Repository("elementDao")
public class ElementDaoImpl extends AbstractBaseDaoSupport implements ElementDao {
	
	@Override
	public List<ElementTypeE> getEntitledElements(String username) {
		List<ElementTypeE> list = new ArrayList<>();
		for(ElementTypeE type : ElementTypeE.values()) {
			list.add(type);
		}
		return list;
	}
}
