package com.fanhehe.httputil.result;

import java.io.Serializable;

public interface IResult<T> extends Serializable {

    /**
     * 判断调用是否成功
     * @return 成功 true 失败 false
     */
    boolean isSuccess();

    /**
     * 获取负载信息
     * @return 负载信息
     */
    T getData();

    /**
     * 设置负载信息
     * @param data 设置负载信息
     */
    void setData(T data);

    /**
     * 设置code
     * @param code 代码
     */
    void setCode(int code);

    /**
     * 设置调用message
     * @param message 调用message
     */
    void setMessage(String message);

    default int getCode() {
        return 0;
    }

    default String getMessage() {
        return "";
    }

    default boolean isFailure() {
        return !isSuccess();
    }
}
