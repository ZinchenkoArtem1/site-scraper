package ua.zinchenko.sitescraper.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorConfig {

    private ExecutorConfig() {}

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);

    public static ExecutorService getExecutorService() {
        return EXECUTOR_SERVICE;
    }
}
