package dev.ananda.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ananda on 06-10-2019.
 */
public class ConfigurationProvider {

    private ConfigurationProvider(){}

    private static ConfigurationProvider instance;

    private static Map<String, String> errorMessages;

    private static final String DEFAULT_ERROR_MESSAGE = "";

    static {
        instance = new ConfigurationProvider();
        errorMessages = new HashMap<String, String>();
    }

    public static ConfigurationProvider getInstance(){
        return instance;
    }

//    chain of responsility
//        extract -> transform -> load
    public String getErrorMessage(String key){
        return errorMessages.getOrDefault(key, DEFAULT_ERROR_MESSAGE);
    }
}
