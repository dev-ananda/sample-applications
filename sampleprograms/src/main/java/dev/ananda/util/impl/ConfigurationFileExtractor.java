package dev.ananda.util.impl;

import dev.ananda.util.IExtractor;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Ananda on 14-10-2019.
 */
public class ConfigurationFileExtractor implements IExtractor {

    public JSONObject extract(JSONObject in) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        Path filePath = Paths.get(classLoader.getResource("ErrorMessages.json").toURI());
        JSONObject json = new JSONObject();
        json.put("filePath", filePath);
        return json;
    }
}
