package br.com.marcelodaniel.mycommands.database.configuration;

import br.com.marcelodaniel.mycommands.database.CrudDatabase;
import br.com.marcelodaniel.mycommands.database.conditions.SqlWhere;

import java.sql.*;
import java.util.*;

import static java.lang.String.format;

public class ConfigurationDatabaseHelper implements CrudDatabase {

    public static final String KEY_PROJECT_PATH = "project.path";
    public static final String KEY_MAVEN_PATH = "maven.path";

    @Override
    public List<Map<String, Object>> select(String table, List<String> columns, Map<String, Object> wheres) {
        List<Map<String, Object>> results = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco.db")) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(format("SELECT * FROM %s", table));

            while (rs.next()) {
                Map<String, Object> cols = new HashMap<>();
                for (String column : columns) {
                    cols.put(column, rs.getString(column));
                }
                results.add(cols);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return results;
    }

    @Override
    public boolean update(String table, List<Map<String, Object>> values, List<SqlWhere> wheres) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco.db")) {
            List<String> columnsArr = new ArrayList<>();
            List<String> valuesArr = new ArrayList<>();

            for (Map<String, Object> map : values) {
                columnsArr.addAll(map.keySet());
                List<String> valuesCols = new ArrayList<>();
                columnsArr.forEach(s -> {
                    if (map.get(s) instanceof String) {
                        valuesCols.add("'" + map.get(s).toString() + "'");
                    } else if (map.get(s) instanceof Integer) {
                        valuesCols.add(map.get(s).toString());
                    }
                });
                valuesArr.add("(" + String.join(", ", valuesCols) + ")");
            }

            Statement stmt = connection.createStatement();
            String sql = format(
                    "UPDATE %s SERT (%s) VALUES %s;",
                    table,
                    String.join(", ", columnsArr),
                    String.join(", ", valuesArr)
            );
            System.out.println(sql);

//            return stmt.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean insert(String table, List<Map<String, Object>> values) {

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco.db")) {

            List<String> columnsArr = new ArrayList<>();
            List<String> valuesArr = new ArrayList<>();

            for (Map<String, Object> map : values) {
                columnsArr.addAll(map.keySet());
                List<String> valuesCols = new ArrayList<>();
                columnsArr.forEach(s -> {
                    if (map.get(s) instanceof String) {
                        valuesCols.add("'" + map.get(s).toString() + "'");
                    } else if (map.get(s) instanceof Integer) {
                        valuesCols.add(map.get(s).toString());
                    }
                });
                valuesArr.add("(" + String.join(", ", valuesCols) + ")");
            }

            Statement stmt = connection.createStatement();
            String sql = format(
                    "INSERT INTO %s (%s) VALUES %s;",
                    table,
                    String.join(", ", columnsArr),
                    String.join(", ", valuesArr)
            );
            System.out.println(sql);

            return stmt.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(String table, Map<String, Object> wheres) {
        return false;
    }

}
