package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Global metrics registry implemented as a thread-safe Singleton.
 *
 * FIXED IMPLEMENTATION:
 * - Private constructor prevents direct instantiation.
 * - Bill Pugh Singleton pattern ensures thread-safe lazy initialization.
 * - Reflection attacks blocked via constructor check.
 * - Serialization safety via readResolve().
 */
public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Map<String, Long> metrics = new HashMap<>();

    private MetricsRegistry() {
        if (SingletonHolder.INSTANCE != null) {
            throw new IllegalStateException("Singleton already initialized - use getInstance() instead");
        }
    }

    private static class SingletonHolder {
        private static final MetricsRegistry INSTANCE = new MetricsRegistry();
    }

    public static MetricsRegistry getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public synchronized void setCount(String key, long value) {
        metrics.put(key, value);
    }

    public synchronized void increment(String key) {
        metrics.put(key, getCount(key) + 1);
    }

    public synchronized long getCount(String key) {
        return metrics.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(metrics));
    }

    @Serial
    private Object readResolve() {
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of singleton is not allowed");
    }
}
