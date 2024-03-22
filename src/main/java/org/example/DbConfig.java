package org.example;

public class DbConfig {
    private static final String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    public String getDbUrl() {
        return DB_URL;
    }

    public String getUsername() {
        return DB_USER;
    }

    public String getPassword() {
        return DB_PASSWORD;
    }
}
