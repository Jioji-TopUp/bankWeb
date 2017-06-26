package cn.com.ultrawise.bank.bnk.webapp.form;

import cn.com.ultrawise.bank.webapp.form.BaseForm;


/**
 * @author zhouxing email:admin@zhouxing.org
 *
 */
public class BnkBankForm extends BaseForm implements java.io.Serializable {
	/*ÀΩ”– Ù–‘∫Õget()/set()*/
	private String bnkBankId;
	private String bnkCode;
	private String bnkBankEname;
	private String bnkBankCname;
	public String getBnkBankId() {
		return bnkBankId;
	}
	public void setBnkBankId(String bnkBankId) {
		this.bnkBankId = bnkBankId;
	}
	public String getBnkCode() {
		return bnkCode;
	}
	public void setBnkCode(String bnkCode) {
		this.bnkCode = bnkCode;
	}
	public String getBnkBankEname() {
		return bnkBankEname;
	}
	public void setBnkBankEname(String bnkBankEname) {
		this.bnkBankEname = bnkBankEname;
	}
	public String getBnkBankCname() {
		return bnkBankCname;
	}
	public void setBnkBankCname(String bnkBankCname) {
		this.bnkBankCname = bnkBankCname;
	}	
}
