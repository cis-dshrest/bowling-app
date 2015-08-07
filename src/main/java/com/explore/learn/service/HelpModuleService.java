package com.explore.learn.service;

import java.util.List;

import com.explore.learn.model.HelpModule;

public interface HelpModuleService {
	
	HelpModule findByPageTitle(String pageTitle);
	
	void saveHelpModule(HelpModule helpModule);
	
	void updateHelpModule(HelpModule employee);
	
	void deleteHelpModuleByPageTitle(String pageTitle);

	List<HelpModule> findAllEmployees(); 
	
	HelpModule findHelpModuleByPageTitle(String pageTitle);

	boolean isHelpModuleUnique(String pageTitle);
	
}
