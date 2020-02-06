package dev.ananda.util;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Ananda on 06-10-2019.
 */
public interface ILoader {
    JSONObject load(JSONObject in) throws URISyntaxException, IOException;
}
