package org.example;

import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {

            DbConfig dbConfig = new DbConfig();
            Flyway flyway = Flyway.configure()
                    .dataSource(dbConfig.getDbUrl(),dbConfig.getUsername(), dbConfig.getPassword())
                    .load();
            flyway.migrate();
        }
    }
