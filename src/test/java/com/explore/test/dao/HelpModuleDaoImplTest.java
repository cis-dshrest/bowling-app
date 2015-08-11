package com.explore.test.dao;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.explore.learn.dao.HelpModuleDao;
import com.explore.learn.model.HelpModule;


public class HelpModuleDaoImplTest extends EntityDaoImplTest{

	@Autowired
	HelpModuleDao helpModuleDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("HelpModule.xml"));
		return dataSet;
	}

	@Test
	public void findByPageTitle(){
		Assert.assertNotNull(helpModuleDao.findByPageTitle("Home"));
		Assert.assertNull(helpModuleDao.findByPageTitle("Nonexistant"));
	}

	
	@Test
	public void saveEmployee(){
		helpModuleDao.saveHelpModule(getSampleHelpModule());
		Assert.assertEquals(helpModuleDao.findAllHelpModules().size(), 2);
	}
	
	@Test
	public void deleteHelpModuleByPageTitle(){
		helpModuleDao.deleteHelpModuleByPageTitle("About");
		Assert.assertEquals(helpModuleDao.findAllHelpModules().size(), 1);
	}
	
	@Test
	public void deleteHelpModuleByInvalidPageTitle(){
		helpModuleDao.deleteHelpModuleByPageTitle("wiki");
		Assert.assertEquals(helpModuleDao.findAllHelpModules().size(), 2);
	}

	@Test
	public void findAllEmployees(){
		Assert.assertEquals(helpModuleDao.findAllHelpModules().size(), 2);
	}
	

	public HelpModule getSampleHelpModule(){
		HelpModule hm = new HelpModule();
		hm.setId(1);
		hm.setPageTitle("Home");
		return hm;
	}

}
