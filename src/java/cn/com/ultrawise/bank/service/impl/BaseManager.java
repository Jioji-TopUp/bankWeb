package cn.com.ultrawise.bank.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import cn.com.ultrawise.bank.dao.Dao;
import cn.com.ultrawise.bank.service.Manager;

/**
 * @author ÖÜÐÐ email: admin@zhouxing.org
 *
 */
public class BaseManager implements Manager {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	protected Dao dao = null;

	
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public Object getObject(Class<Object> clazz, Serializable id) {
		return dao.getObject(clazz, id);
	}

	public List<Object> getObjects(Class<Object> clazz) {
		return dao.getObjects(clazz);
	}

	public void removeObject(Class<Object> clazz, Serializable id) {
		dao.removeObject(clazz, id);
	}

	public void saveObject(Object o) {
		dao.saveObject(o);
	}
}
