package cn.com.ultrawise.bank.service;


/**
 * @author ÖÜÐÐ email: admin@zhouxing.org
 *
 */
public class UserExistsException extends Exception {
	private static final long serialVersionUID = 4050482305178810162L;


    public UserExistsException(String message) {
        super(message);
    }
}
