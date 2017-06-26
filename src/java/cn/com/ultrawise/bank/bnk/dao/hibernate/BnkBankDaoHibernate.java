package cn.com.ultrawise.bank.bnk.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import cn.com.ultrawise.bank.bnk.dao.BnkBankDao;
import cn.com.ultrawise.bank.bnk.model.BnkBank;
import cn.com.ultrawise.bank.dao.hibernate.BaseDaoHibernate;


/**
 * @author zhouxing email:admin@zhouxing.org
 *
 */
public class BnkBankDaoHibernate extends BaseDaoHibernate implements BnkBankDao {

	public List<BnkBank> listBnkBank() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().loadAll(BnkBank.class);
	}

	public void addBnkBank(BnkBank bnkBank) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(bnkBank);
	}

	public BnkBank queryBnkBank(String bnkId, String bnkCode) {
		// TODO Auto-generated method stub
		String hql = "from cn.com.ultrawise.bank.bnk.model.BnkBank bnk";
		String whereClause = "";
		List<String> whereParam = new ArrayList<String>();
		if(!"".equals(bnkId)){
			whereClause += " where bnk.bnkBankId=?";
			whereParam.add(bnkId);
		}
		if(!"".equals(bnkCode)){
			whereClause += whereClause.length()>0?
					" and bnk.bnkCode=?":" where bnk.bnkCode=?";
			whereParam.add(bnkCode);
		}
		hql += whereClause;
		BnkBank bnkBank = (BnkBank)getHibernateTemplate()
				.find(hql, whereParam).get(0);
		return bnkBank;
	}
	
	
}
