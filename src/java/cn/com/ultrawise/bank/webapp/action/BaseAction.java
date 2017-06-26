package cn.com.ultrawise.bank.webapp.action;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import cn.com.ultrawise.bank.Constants;
import cn.com.ultrawise.bank.util.ConvertUtil;
import cn.com.ultrawise.bank.util.CurrencyConverter;
import cn.com.ultrawise.bank.util.DateConverter;

/**
 * @author ÖÜÐÐ email: admin@zhouxing.org
 * 
 */
public class BaseAction extends DispatchAction {
	protected final Log log = LogFactory.getLog(getClass());
	private static final Long defaultLong = null;

	static {
		ConvertUtils.register(new CurrencyConverter(), Double.class);
		ConvertUtils.register(new DateConverter(), Date.class);
		ConvertUtils.register(new DateConverter(), String.class);
		ConvertUtils.register(new LongConverter(defaultLong), Long.class);
		ConvertUtils.register(new IntegerConverter(defaultLong), Integer.class);
	}

	protected Object convert(Object o) throws Exception {
		return ConvertUtil.convert(o);
	}

	protected Object convertLists(Object o) throws Exception {
		return ConvertUtil.convertLists(o);
	}

	public ActionMessages getMessages(HttpServletRequest request) {
		ActionMessages messages = null;
		HttpSession session = request.getSession();

		if (request.getAttribute(Globals.MESSAGE_KEY) != null) {
			messages = (ActionMessages) request
					.getAttribute(Globals.MESSAGE_KEY);
			saveMessages(request, messages);
		} else if (session.getAttribute(Globals.MESSAGE_KEY) != null) {
			messages = (ActionMessages) session
					.getAttribute(Globals.MESSAGE_KEY);
			saveMessages(request, messages);
			session.removeAttribute(Globals.MESSAGE_KEY);
		} else {
			messages = new ActionMessages();
		}

		return messages;
	}

	private String getActionMethodWithMapping(HttpServletRequest request,
			ActionMapping mapping) {
		return getActionMethod(request, mapping.getParameter());
	}

	protected String getActionMethod(HttpServletRequest request, String prepend) {
		String name = null;

		name = request.getParameter(prepend);
		if (name != null) {
			name = name.trim();
			return name.replace(name.charAt(0), Character.toLowerCase(name
					.charAt(0)));
		}

		Enumeration e = request.getParameterNames();

		while (e.hasMoreElements()) {
			String currentName = (String) e.nextElement();

			if (currentName.startsWith(prepend + ".")) {
				if (log.isDebugEnabled()) {
					log.debug("calling method: " + currentName);
				}

				String[] parameterMethodNameAndArgs = StringUtils.split(
						currentName, ".");
				name = parameterMethodNameAndArgs[1];
				break;
			}
		}

		return name;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if (isCancelled(request)) {
			try {
				getMethod("cancel");
				return dispatchMethod(mapping, form, request, response,
						"cancel");
			} catch (NoSuchMethodException n) {
				log.warn("No 'cancel' method found, returning null");
				return cancelled(mapping, form, request, response);
			}
		}

		String actionMethod = getActionMethodWithMapping(request, mapping);

		if (actionMethod != null) {
			return dispatchMethod(mapping, form, request, response,
					actionMethod);
		} else {
			String[] rules = { "edit", "save", "search", "view" };
			for (int i = 0; i < rules.length; i++) {
				if (request.getServletPath().indexOf(rules[i]) > -1) {
					return dispatchMethod(mapping, form, request, response,
							rules[i]);
				}
			}
		}

		return super.execute(mapping, form, request, response);
	}

	protected ActionForm getActionForm(ActionMapping mapping,
			HttpServletRequest request) {
		ActionForm actionForm = null;

		if (mapping.getAttribute() != null) {
			if ("request".equals(mapping.getScope())) {
				actionForm = (ActionForm) request.getAttribute(mapping
						.getAttribute());
			} else {
				HttpSession session = request.getSession();
				actionForm = (ActionForm) session.getAttribute(mapping
						.getAttribute());
			}
		}

		return actionForm;
	}

	public Map getConfiguration() {
		Map config = (HashMap) getServlet().getServletContext().getAttribute(
				Constants.CONFIG);

		if (config == null) {
			return new HashMap();
		}

		return config;
	}

	protected void removeFormBean(ActionMapping mapping,
			HttpServletRequest request) {
		if (mapping.getAttribute() != null) {
			if ("request".equals(mapping.getScope())) {
				request.removeAttribute(mapping.getAttribute());
			} else {
				HttpSession session = request.getSession();
				session.removeAttribute(mapping.getAttribute());
			}
		}
	}

	protected void updateFormBean(ActionMapping mapping,
			HttpServletRequest request, ActionForm form) {
		if (mapping.getAttribute() != null) {
			if ("request".equals(mapping.getScope())) {
				request.setAttribute(mapping.getAttribute(), form);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute(mapping.getAttribute(), form);
			}
		}
	}
}
