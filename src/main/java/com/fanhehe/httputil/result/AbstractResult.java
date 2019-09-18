package com.fanhehe.httputil.result;


/**
 * 抽象方法，实现最基本的封装
 * @param <T>
 */
public abstract class AbstractResult<T> implements IResult<T> {

    private int code = 0;
    private T data = null;
    private String message = "";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return code == 0;
    }
}
