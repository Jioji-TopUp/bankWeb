package cn.com.ultrawise.bank.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.lang.StringUtils;

/**
 * @author ÖÜÐÐ email: admin@zhouxing.org
 * 
 */
public class TimestampConverter extends DateConverter {
	public static final String TS_FORMAT = DateUtil.getDatePattern()
			+ " HH:mm:ss.S";

	protected Object convertToDate(Class<Object> type, Object value) {
		DateFormat df = new SimpleDateFormat(TS_FORMAT);
		if (value instanceof String) {
			try {
				if (StringUtils.isEmpty(value.toString())) {
					return null;
				}

				return df.parse((String) value);
			} catch (Exception pe) {
				throw new ConversionException(
						"Error converting String to Timestamp");
			}
		}

		throw new ConversionException("Could not convert "
				+ value.getClass().getName() + " to " + type.getName());
	}

	protected Object convertToString(Class<?> type, Object value) {
		DateFormat df = new SimpleDateFormat(TS_FORMAT);
		if (value instanceof Date) {
			try {
				return df.format(value);
			} catch (Exception e) {
				throw new ConversionException(
						"Error converting Timestamp to String");
			}
		}

		return value.toString();
	}
}
