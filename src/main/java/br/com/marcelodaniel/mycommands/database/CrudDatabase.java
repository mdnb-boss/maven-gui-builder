package br.com.marcelodaniel.mycommands.database;

import br.com.marcelodaniel.mycommands.database.conditions.SqlWhere;

import java.util.List;
import java.util.Map;

public interface CrudDatabase {

    List<Map<String, Object>> select(String table, List<String> columns, Map<String, Object> wheres);

    boolean update(String table, List<Map<String, Object>> values, List<SqlWhere> wheres);

    boolean insert(String table, List<Map<String, Object>> values);

    boolean delete(String table, Map<String, Object> wheres);

}
