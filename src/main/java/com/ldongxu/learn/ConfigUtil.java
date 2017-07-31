package com.ldongxu.learn;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * typesafe.config demo
 * <p>
 * Created by 刘东旭 on 2017/6/7.
 */
public class ConfigUtil {
    private final static Config config;

    static {
        config = ConfigFactory.load();
    }

    public static String getString(String var) {
        return config.getString(var);
    }

    public static Config getConfig() {
        return config;
    }


}
