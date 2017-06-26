package cn.com.ultrawise.bank.bnk.service.impl;

import cn.com.ultrawise.bank.bnk.dao.BnkBankDao;
import java.util.List;

import cn.com.ultrawise.bank.bnk.model.BnkBank;
import cn.com.ultrawise.bank.bnk.service.BnkBankManager;
import cn.com.ultrawise.bank.service.impl.BaseManager;

/**
 * @author zhouxing email:admin@zhouxing.org
 *
 */
public class BnkBankManagerImpl extends BaseManager implements BnkBankManager {
	private BnkBankDao bnkBankDao;
	
	public void setBnkBankDao(BnkBankDao bnkBankDao) {
		this.bnkBankDao = bnkBankDao;
	}

	public List<BnkBank> listBnkBank() {
		// TODO Auto-generated method stub
		return bnkBankDao.listBnkBank();
	}

	public void addBnkBank(BnkBank bnkBank) {
		// TODO Auto-generated method stub
		bnkBankDao.addBnkBank(bnkBank);
	}

	public BnkBank queryBnkBank(String bnkId, String bnkCode) {
		// TODO Auto-generated method stub
		return bnkBankDao.queryBnkBank(bnkId, bnkCode);
	}
	
}
