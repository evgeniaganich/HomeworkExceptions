public class Data {

    private static final String ALLOWED_SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdetghijklmnopqrstuvwxyz1234567890_";

    private Data() {

    }

    public static boolean validate
            (String login,
             String password,
             String confirmPassword) {
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void check
            (String login,
             String password,
             String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!isValid(login)) {
            throw new WrongLoginException("Логин не может быть длиннее 20 символов и может состоять только из латинских букв и знака _");
        }
        if (!isValid(password)) {
            throw new WrongPasswordException("Пароль не может быть длиннее 20 символов, состоит из латинских букв и знака _");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Введенные пароли не совпадают");
        }
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() > 20) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!ALLOWED_SYMBOLS.contains(String.valueOf(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }


}

