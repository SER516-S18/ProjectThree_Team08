package model;

public class MessageBean {
    private String content;
    private String sender;
    public MessageBean(String content,String sender)
    {
        this.content=content;
        this.sender=sender;
    }
    public final String getContent() {
        return content;
    }

    public final void setContent(final String content) {
        this.content = content;
    }

    public final String getSender() {
        return sender;
    }

    public final void setSender(final String sender) {
        this.sender = sender;
    }
}
