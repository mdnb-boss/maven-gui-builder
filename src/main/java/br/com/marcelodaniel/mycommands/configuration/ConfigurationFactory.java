package br.com.marcelodaniel.mycommands.configuration;

import java.io.IOException;

public interface ConfigurationFactory {
    abstract void addProjectPath(String value) throws IOException;
    abstract void addMavenPath(String value) throws IOException;
    abstract String get(String key);
}
