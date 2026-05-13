package data;

import helpers.Settings;

public class AccountData {
    private final String username;
    private final String password;

    public AccountData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static AccountData validAccount() {
        return new AccountData(Settings.getLogin(), Settings.getPassword());
    }
}