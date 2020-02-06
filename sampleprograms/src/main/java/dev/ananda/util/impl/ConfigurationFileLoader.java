package dev.ananda.util.impl;

import dev.ananda.util.ILoader;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Ananda on 06-10-2019.
 */
public class ConfigurationFileLoader implements ILoader {

    @Override
    public JSONObject load(JSONObject in) throws URISyntaxException, IOException {
        Path filePath = (Path) in.get("filePath");
        Stream<String> lines = Files.lines(filePath);
        String linesData = lines.collect(Collectors.joining(""));
        lines.close();

        JSONObject out = new JSONObject();
        out.put("errormessages", linesData);

        return out;
    }
}
