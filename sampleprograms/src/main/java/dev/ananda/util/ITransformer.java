package dev.ananda.util;

import org.json.JSONObject;

/**
 * Created by Ananda on 06-10-2019.
 */
public interface ITransformer {
    JSONObject transform(JSONObject in);
}
