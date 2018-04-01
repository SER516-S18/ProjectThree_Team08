package main.model;

import com.google.gson.Gson;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * Encoder which converts java object to json.
 * @author Balachandar Sampath
 * @version 1.0
 */
public class MessageEncoder implements Encoder.Text<EmotionMessageBean> {
    private static Gson gson = new Gson();

    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(final EmotionMessageBean message) throws EncodeException {
        return gson.toJson(message);
    }

}
