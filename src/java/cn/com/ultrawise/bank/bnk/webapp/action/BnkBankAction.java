package cn.com.ultrawise.bank.bnk.webapp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.com.ultrawise.bank.bnk.model.BnkBank;
import cn.com.ultrawise.bank.bnk.service.BnkBankManager;
import cn.com.ultrawise.bank.bnk.webapp.form.BnkBankForm;
import cn.com.ultrawise.bank.webapp.action.BaseAction;

/**
 * 
 * @author zhouxing email: admin@zhouxing.org
 * 
 */
public final class BnkBankAction extends BaseAction {
	private BnkBankManager bnkBankManager;

	public void setBnkBankManager(BnkBankManager bnkBankManager) {
		this.bnkBankManager = bnkBankManager;
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BnkBankForm bnkBankForm = (BnkBankForm) form;
		BnkBank bnkBank = (BnkBank) convert(bnkBankForm);
		bnkBankManager.addBnkBank(bnkBank);
		return mapping.findForward("list");
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<BnkBank> bnkBanklist = bnkBankManager.listBnkBank();
		request.setAttribute("bnkList", bnkBanklist);
		return mapping.findForward("list");
	}

	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BnkBankForm bnkBankForm = (BnkBankForm) form;
		String bnkId = bnkBankForm.getBnkBankId();
		String bnkCode = bnkBankForm.getBnkCode();
		BnkBank bnkBank = bnkBankManager.queryBnkBank(bnkId, bnkCode);
		request.setAttribute("bnk", bnkBank);
		return mapping.findForward("query");
	}
}
