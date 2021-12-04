package br.com.marcelodaniel.mycommands.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationFactoryImpl implements ConfigurationFactory {

    public static final String KEY_PROJECT_PATH = "project.path";
    public static final String KEY_MAVEN_PATH = "maven.path";
    private Properties props;

    public ConfigurationFactoryImpl() throws IOException {
        createFileConfig();
        props = new Properties();
        FileInputStream file = new FileInputStream("./configuration.properties");
        props.load(file);
    }

    private void createFileConfig() throws IOException {
        File file = new File("./configuration.properties");
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    @Override
    public void addProjectPath(String value) throws IOException {
        props.setProperty(KEY_PROJECT_PATH, value);
        FileOutputStream fos = new FileOutputStream("./configuration.properties");
        props.store(fos, "");
        fos.close();
    }

    @Override
    public void addMavenPath(String value) throws IOException {
        props.setProperty(KEY_MAVEN_PATH, value);
        FileOutputStream fos = new FileOutputStream("./configuration.properties");
        props.store(fos, "");
        fos.close();
    }

    @Override
    public String get(String key) {
        return props.getProperty(key);
    }
}
