package utils;

import javax.json.Json;

public class JsonUtil {

    public static String formatMessage(String message, String client) {
        return Json.createObjectBuilder()
                .add("message", message)
                .add("sender", client)
                .build().toString();
    }

}
