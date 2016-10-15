package com.mars.tea.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mars.tea.springmvc.dao.ElementDao;
import com.mars.tea.springmvc.enums.ElementTypeE;
import com.mars.tea.springmvc.service.ElementService;

@Service("elementService")
public class ElementServiceImpl implements ElementService {
	
	@Autowired
	@Qualifier("elementDao")
	private ElementDao elementDao;

	@Override
	public List<ElementTypeE> getEntitledElements(String username) {
		return elementDao.getEntitledElements(username);
	}
	
}
