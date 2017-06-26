package cn.com.ultrawise.bank;

/**
 * 应用程序中的常量
 * @author zhouxing admin@zhouxing.org
 */
public class Constants {
	// =====================静态常量初始化========================

	/** 应用程序中绑定资源所用到的常量 */
	public static final String BUNDLE_KEY = "ApplicationResources";

	/** 配置hashmap所用到的常量 */
	public static final String CONFIG = "appConfig";

	/**
	 * Session scope attribute that holds the locale set by the user. By setting
	 * this key to the same one that Struts uses, we get synchronization in
	 * Struts w/o having to do extra work or have two session-level variables.
	 */
	public static final String PREFERRED_LOCALE_KEY = "org.apache.struts.action.LOCALE";

	/**
	 * 管理员用户
	 */
	public static final String ADMIN_ROLE = "admin";

	/**
	 * 样式主题设定
	 */
	public static final String CSS_THEME = "csstheme";
	
	// =====================用户操作信息常量========================

	/**
	 * 用户信息list
	 */
	public static final String OPEOPERATOR_LIST = "opeOperatorList";

	// =====================货币种类信息常量========================

	/**
	 * 货币种类信息list
	 */
	public static final String CCYCURRENCY_LIST = "ccyCurrencyList";

	/**
	 * 货币种类Form
	 */
	public static final String CCYCURRENCY_FORM = "ccyCurrencyForm";

	// =====================客户基本信息维护常量========================

	/**
	 * 货币种类信息list
	 */
	public static final String CRECREDIT_LIST = "creCreditList";

	/**
	 * 货币种类form
	 */
	public static final String CRECREDIT_FORM = "creCreditForm";

	// =====================信贷等级常量========================

	/**
	 * 信贷等级信息list
	 */
	public static final String LGRLENDINGGRADE_LIST = "lgrLendingGradeList";
	/**
	 * 信贷等级form
	 */
	public static final String LGRLENDINGGRADE_FORM = "lgrLendingGradeForm";

	// =====================客户财务数据维护常量========================

	/**
	 * 客户财务数据信息list
	 */
	public static final String CFDCUSTFINDATA_LIST = "cfdCustFinDataList";
	public static final String MONTH_LST = "monthLst";
	
	// =====================银行列表常量========================

	/**
	 * 银行列表list
	 */
	public static final String BNKBANK_LIST = "bnkBankList";
	
	/**
	 * 银行列表form
	 */
	public static final String BNKBANK_FORM = "bnkBankForm";

}
