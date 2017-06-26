package cn.com.ultrawise.bank.bnk.service;

import java.util.List;

import cn.com.ultrawise.bank.bnk.model.BnkBank;
import cn.com.ultrawise.bank.service.Manager;


/**
 * @author zhouxing email:admin@zhouxing.org
 *
 */
public interface BnkBankManager extends Manager {
	public List<BnkBank> listBnkBank();
	public void addBnkBank(BnkBank bnkBank);
	public BnkBank queryBnkBank(String bnkId,String bnkCode);	
}
