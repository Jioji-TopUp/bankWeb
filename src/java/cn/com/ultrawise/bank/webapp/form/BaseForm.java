package cn.com.ultrawise.bank.webapp.form;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;
import org.apache.struts.validator.ValidatorForm;

/**
 * @author ÖÜÐÐ email: admin@zhouxing.org
 * 
 */
public class BaseForm extends ValidatorForm implements Serializable {

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		String parameter = mapping.getParameter();

		if (parameter != null) {
			String method = request.getParameter(parameter);
			MessageResources resources = (MessageResources) request
					.getAttribute(Globals.MESSAGES_KEY);

			String cancel = resources.getMessage("button.cancel");
			String delete = resources.getMessage("button.delete");

			if ((method != null)
					&& (method.equalsIgnoreCase(cancel) || method
							.equalsIgnoreCase(delete))) {
				return null;
			}
		}

		return super.validate(mapping, request);
	}
}
