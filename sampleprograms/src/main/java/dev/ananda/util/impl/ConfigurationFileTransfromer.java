package dev.ananda.util.impl;

import dev.ananda.util.ITransformer;
import org.json.JSONObject;

/**
 * Created by Ananda on 14-10-2019.
 */
public class ConfigurationFileTransfromer implements ITransformer {

    @Override
    public JSONObject transform(JSONObject in) {
        String linesData = (String) in.get("errormessages");
        JSONObject out = new JSONObject();
        out.put("errormessages", new JSONObject(linesData));

        return out;
    }
}
