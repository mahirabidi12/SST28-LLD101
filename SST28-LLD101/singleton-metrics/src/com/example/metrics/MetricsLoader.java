package com.example.metrics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Loads default metric keys from a properties file into the singleton registry.
 *
 * FIXED: Now uses MetricsRegistry.getInstance() instead of direct instantiation.
 */
public class MetricsLoader {

    public MetricsRegistry loadFromFile(String path) throws IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            props.load(fis);
        }

        MetricsRegistry registry = MetricsRegistry.getInstance();

        for (String key : props.stringPropertyNames()) {
            String raw = props.getProperty(key, "0").trim();
            long val;
            try {
                val = Long.parseLong(raw);
            } catch (NumberFormatException e) {
                val = 0L;
            }
            registry.setCount(key, val);
        }
        return registry;
    }
}
