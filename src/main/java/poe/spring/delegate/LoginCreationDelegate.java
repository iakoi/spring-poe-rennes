package poe.spring.delegate;

public class LoginCreationDelegate {

	public static final int MIN_LOGIN_LENGTH = 4;
	public static final int MAX_LOGIN_LENGTH = 10;
	public static final String[] FORBIDDEN_LOGIN = {"rechercherParVilleDepart", "tata", "titi"};


	public static boolean isSizeValid(String login) {
		boolean isValid;
		isValid = login.length() >= MIN_LOGIN_LENGTH && login.length() <= MAX_LOGIN_LENGTH;
		return isValid;
	}

	public static boolean isAuthorized(String login) {
		boolean isAuthorized = true;
		for (int i = 0; (i < FORBIDDEN_LOGIN.length) && isAuthorized; i++) {
			if (FORBIDDEN_LOGIN[i].equals(login)) {
				isAuthorized = false;
			}
		}
		return isAuthorized;
	}


}
