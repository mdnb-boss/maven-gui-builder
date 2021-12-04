package br.com.marcelodaniel.mycommands.executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecutorTask implements Runnable {

    private final String cmd;

    private final LoggerFactory loggerFactory;

    public interface LoggerFactory {
        void sendLine(String line);
    }

    public ExecutorTask(String cmd, LoggerFactory loggerFactory) {
        this.cmd = cmd;
        this.loggerFactory = loggerFactory;
    }

    @Override
    public void run() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line="";
            while ((line = reader.readLine()) != null) {
                loggerFactory.sendLine(line + "\n");
            }
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            return;
        }
    }

}
