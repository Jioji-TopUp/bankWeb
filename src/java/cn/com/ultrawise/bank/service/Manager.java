package cn.com.ultrawise.bank.service;

import java.io.Serializable;
import java.util.List;

import cn.com.ultrawise.bank.dao.Dao;

/**
 * @author ÖÜÐÐ email: admin@zhouxing.org
 *
 */
public interface Manager {


	public void setDao(Dao dao);

	
	public List<Object> getObjects(Class<Object> clazz);

	
	public Object getObject(Class<Object> clazz, Serializable id);


	public void saveObject(Object o);

	
	public void removeObject(Class<Object> clazz, Serializable id);
}
