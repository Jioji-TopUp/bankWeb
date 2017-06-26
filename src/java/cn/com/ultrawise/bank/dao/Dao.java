package cn.com.ultrawise.bank.dao;

import java.io.Serializable;
import java.util.List;


/**
 * @author ÖÜÐÐ email: admin@zhouxing.org
 *
 */
public interface Dao {

	
	public List<Object> getObjects(Class<Object> clazz);

	
	public Object getObject(Class<Object> clazz, Serializable id);

	
	public void saveObject(Object o);

	
	public void removeObject(Class<Object> clazz, Serializable id);
}
