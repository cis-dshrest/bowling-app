package com.explore.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelpModuleService {
	
	private HelpModuleDao hmDao;
	
	public HelpModuleDao getHelpModuleDao() {
		return hmDao;
	}
	
	@Autowired
	public void setHelpModuleDao(HelpModuleDao hmDao) {
		this.hmDao = hmDao;
	}
	
	public List<HelpModule> fetchAll() {
		return getHelpModuleDao().selectAll();
	}
	
}
