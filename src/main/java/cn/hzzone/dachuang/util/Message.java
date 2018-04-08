package cn.hzzone.dachuang.util;

public class Message<T> {
    private T data = null;
    private int code = 1;
    private String msg = null;

    public void setData(T data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {


        return data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Message(T data, int code) {
        this.data = data;
        this.code = code;
    }

    public Message(T data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }
}
