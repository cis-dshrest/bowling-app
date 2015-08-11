package com.explore.learn.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.explore.learn.model.HelpModule;

@Repository("helpModuleDao")
public class HelpModuleDaoImpl extends AbstractDao<Integer, HelpModule> implements HelpModuleDao {

	public HelpModule findByPageTitle(String pageTitle) {
		return getByKey(pageTitle);
	}

	public void saveHelpModule(HelpModule helpModule) {
		persist(helpModule);	
	}

	public void deleteHelpModuleByPageTitle(String pageTitle) {
		Query query = getSession().createSQLQuery("delete from helpmessage where title = :title");
		query.setString("pageTitle", pageTitle);
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	public List<HelpModule> findAllHelpModules() {
		Criteria criteria = createEntityCriteria();
		return (List<HelpModule>) criteria.list();
	}

	public HelpModule findHelpModuleByPageTitle(String pageTitle) {
		Criteria criteria = getSession().createCriteria(HelpModule.class);
		criteria.add(Restrictions.eq("pageTitle", pageTitle));
		return (HelpModule) criteria.uniqueResult();		
	}

}
