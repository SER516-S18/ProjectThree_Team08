package main.model;

import com.google.gson.Gson;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<EmotionMessageBean> {

    private static Gson gson = new Gson();
    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public EmotionMessageBean decode(final String textMessage) throws DecodeException {
        return gson.fromJson(textMessage, EmotionMessageBean.class);
    }

    @Override
    public boolean willDecode(final String s) {
        return true;
    }

}
