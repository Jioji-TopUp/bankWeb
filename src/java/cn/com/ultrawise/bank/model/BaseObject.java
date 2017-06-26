package cn.com.ultrawise.bank.model;

import java.io.Serializable;

/**
 * @author ÖÜÐÐ email: admin@zhouxing.org
 * 
 */
public abstract class BaseObject implements Serializable {
	public abstract String toString();

	public abstract boolean equals(Object o);

	public abstract int hashCode();
}
