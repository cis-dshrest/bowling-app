package com.explore.learn.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.explore.learn.model.HelpModule;
import com.explore.learn.dao.AbstractDao;
import com.explore.learn.dao.HelpModuleDao;

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
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("title", pageTitle));
		System.out.println("helpmodueldaoimpl: " + criteria.uniqueResult().toString());
		return (HelpModule) criteria.uniqueResult();
	}

}
