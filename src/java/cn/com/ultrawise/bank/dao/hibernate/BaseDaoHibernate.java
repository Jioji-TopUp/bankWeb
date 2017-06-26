package cn.com.ultrawise.bank.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import cn.com.ultrawise.bank.dao.Dao;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author ÖÜÐÐ email: admin@zhouxing.org
 *
 */
public class BaseDaoHibernate extends HibernateDaoSupport implements Dao {
	protected final Log log = LogFactory.getLog(getClass());


	public void saveObject(Object o) {
		getHibernateTemplate().saveOrUpdate(o);
	}

	
	public Object getObject(Class<Object> clazz, Serializable id) {
		Object o = getHibernateTemplate().get(clazz, id);

		if (o == null) {
			throw new ObjectRetrievalFailureException(clazz, id);
		}

		return o;
	}

	
	@SuppressWarnings("unchecked")
	public List<Object> getObjects(Class<Object> clazz) {
		return getHibernateTemplate().loadAll(clazz);
	}

	
	public void removeObject(Class<Object> clazz, Serializable id) {
		getHibernateTemplate().delete(getObject(clazz, id));
	}
}
