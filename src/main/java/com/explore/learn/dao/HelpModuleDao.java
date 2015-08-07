package com.explore.learn.dao;

import java.util.List;

import com.explore.learn.model.HelpModule;

public interface HelpModuleDao {

	HelpModule findByPageTitle(String pageTitle);

	void saveHelpModule(HelpModule helpModule);
	
	void deleteHelpModuleByPageTitle(String pageTitle);
	
	List<HelpModule> findAllHelpModules();

	HelpModule findHelpModuleByPageTitle(String pageTitle);

}
