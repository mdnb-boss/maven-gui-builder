package br.com.marcelodaniel.mycommands.database;

import java.sql.*;

public class SQLiteJDBCDriverConnection {

    private static final String TABLE_CONFIG = "CREATE TABLE IF NOT EXISTS config(chave VARCHAR , valor VARCHAR );";

    public static void builder() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco.db")) {
            Statement statement = connection.createStatement();
            statement.execute(TABLE_CONFIG);

            ResultSet rs = statement.executeQuery("SELECT count(*) as rowcount FROM config");
            rs.next();
            int count = rs.getInt("rowcount");
            rs.close();

            if (count == 0) {
                System.out.println("----- Cadastrando configurações iniciais -----");
                String userPath = System.getProperty("user.home");
                statement.execute("INSERT INTO config(chave, valor) values('project.path', '"+userPath+"'), ('maven.path', '"+userPath+"');");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
