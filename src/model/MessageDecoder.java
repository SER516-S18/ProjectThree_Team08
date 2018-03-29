package model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;

public class MessageDecoder implements Decoder.Text<MessageBean> {

    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public MessageBean decode(final String textMessage) throws DecodeException {
        MessageBean message = new MessageBean();
        JsonObject jsonObject = Json.createReader(new StringReader(textMessage)).readObject();
        message.setContent(jsonObject.getString("message"));
        message.setSender(jsonObject.getString("sender"));
        return message;
    }

    @Override
    public boolean willDecode(final String s) {
        return true;
    }

}
