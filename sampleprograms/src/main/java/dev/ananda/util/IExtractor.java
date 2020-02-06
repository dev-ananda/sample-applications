package dev.ananda.util;

import org.json.JSONObject;

import java.net.URISyntaxException;

/**
 * Created by Ananda on 06-10-2019.
 */
public interface IExtractor {
    JSONObject extract(JSONObject in) throws URISyntaxException;
}
