package main.model;

import com.google.gson.Gson;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
/**
 * Decoder which converts json text to java object.
 * @author Balachandar Sampath
 * @version 1.0
 */
public class MessageDecoder implements Decoder.Text<EmotionMessageBean> {

    private static Gson gson = new Gson();
    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    /**
     *
     * @param textMessage this message in json text will be converted to object
     * @return emotionmessagebean object
     * @throws DecodeException
     */
    @Override
    public EmotionMessageBean decode(final String textMessage) throws DecodeException {
        return gson.fromJson(textMessage, EmotionMessageBean.class);
    }

    @Override
    public boolean willDecode(final String s) {
        return true;
    }

}
