package com.explore.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.explore.learn.dao.HelpModuleDao;
import com.explore.learn.model.HelpModule;

@Service("helpModuleService")
@Transactional
public class HelpModuleServiceImpl implements HelpModuleService {

	@Autowired
	private HelpModuleDao dao;
	
	@Override
	public HelpModule findByPageTitle(String pageTitle) {
		return dao.findByPageTitle(pageTitle);
	}

	@Override
	public void saveHelpModule(HelpModule helpModule) {
		dao.saveHelpModule(helpModule);
		
	}
	
	@Override
	public void updateHelpModule(HelpModule helpModule) {
		HelpModule entity = dao.findByPageTitle(helpModule.getPageTitle());
		if(entity!=null){
			entity.setId(helpModule.getId());
			entity.setPageTitle(helpModule.getPageTitle());
			entity.setHelpMessage(helpModule.getHelpMessage());
		}
	}

	@Override
	public void deleteHelpModuleByPageTitle(String pageTitle) {
		dao.deleteHelpModuleByPageTitle(pageTitle);
		
	}

	@Override
	public List<HelpModule> findAllEmployees() {
		return dao.findAllHelpModules();
	}

	@Override
	public HelpModule findHelpModuleByPageTitle(String pageTitle) {
		System.out.println("serviceimpl: ");
		return dao.findHelpModuleByPageTitle(pageTitle);
	}

	@Override
	public boolean isHelpModuleUnique(String pageTitle) {
		HelpModule helpModule = findHelpModuleByPageTitle(pageTitle);
		return ( helpModule == null );
	}


	

}
