package cn.com.ultrawise.bank.bnk.dao;

import java.util.List;

import cn.com.ultrawise.bank.bnk.model.BnkBank;

/**
 * @author zhouxing admin@zhouxing.org
 *
 */
public interface BnkBankDao {
	public List<BnkBank> listBnkBank();
	public void addBnkBank(BnkBank bnkBank);
	public BnkBank queryBnkBank(String bnkId,String bnkCode);
}
