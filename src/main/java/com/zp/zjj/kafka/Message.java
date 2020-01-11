package com.zp.zjj.kafka;

import java.util.Date;

public class Message {

    private Long id;
    private String msg;
    private Date sendTime;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets msg.
     *
     * @param msg the msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Gets send time.
     *
     * @return the send time
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * Sets send time.
     *
     * @param sendTime the send time
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

}
