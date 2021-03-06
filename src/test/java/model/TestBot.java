package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Данный класс используется для взода на портал
 * с помощью учётных данных, расположеных в конфигурационных
 * файлах в директории config.
 */
public class TestBot {
    private final String login;
    private final String password;

    public TestBot(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public TestBot(String configPath) throws IOException {
        BufferedReader authConfig = new BufferedReader(new FileReader(configPath));
        this.login = authConfig.readLine();
        this.password = authConfig.readLine();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
