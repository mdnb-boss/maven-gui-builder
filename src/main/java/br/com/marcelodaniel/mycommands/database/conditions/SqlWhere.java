package br.com.marcelodaniel.mycommands.database.conditions;

public class SqlWhere {

    public enum Condition {
        AND("and"),
        OR("or"),
        EQUAL("="),
        BIGGER_THEN(">"),
        LESS_THAN("<"),
        DIFFERENT("<>"),
        GREATER_EQUAL(">="),
        LESSER_EQUAL("<=");

        private final String description;

        Condition(String condition) {
            this.description = condition;
        }

        public String getDescription() {
            return description;
        }
    }

    private String coluna;
    private Condition condicao;
    private Object valor;

    public SqlWhere(String coluna, Condition condicao, Object valor) {
        this.coluna = coluna;
        this.condicao = condicao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", coluna, condicao.getDescription(), valor);
    }
}
