package com.fanhehe.httputil.http;

import java.util.Map;
import java.util.HashMap;
import com.fanhehe.httputil.result.IResult;

/**
 * 通用HttpUtil工具的接口格式
 * @param <T> 任意对象格式，用户承接服务端返回的数据
 */
public interface IHttpUtil<T> {

    /**
     * 代表GET的请求方法
     */
    String GET = "GET";

    /**
     * 代表POST的请求方法
     */
    String POST = "POST";

    /**
     * 发出带着请求路径、请求参数、请求首部的通用方法
     * @param path 请求路径 /api/...
     * @param params 请求参数 HashMap
     * @param headers 请求首部 HashMap
     * @param method 调用方式，仅支持 GET / POST
     * @return 返回调用的结果，形如IResult
     */
    IResult<T> call(String path, Map<String, String> params, Map<String, String> headers, String method);

    /**
     * 发出仅带着请求路径的GET请求
     * @param path 请求路径
     * @return 调用结果
     */
    default IResult<T> get(String path) {
        return get(path, new HashMap<>(), new HashMap<>());
    }

    /**
     * 发出带着请求路径和请求参数GET请求
     * @param path 请求路径
     * @param params 请求参数
     * @return 调用结果
     */
    default IResult<T> get(String path, Map<String, String> params) {
        return get(path, params, new HashMap<>());
    }

    /**
     * 发出带着参数的POST请求
     * @param path 请求路径
     * @param params 请求参数
     * @return 调用结果
     */
    default IResult<T> post(String path, Map<String, String> params) {
        return post(path, params, new HashMap<>());
    }

    /**
     * 发出带着请求路径、请求参数、请求首部的GET请求
     * @param path 请求路径
     * @param params 请求参数
     * @param headers 请求首部
     * @return 调用结果
     */
    default IResult<T> get(String path, Map<String, String> params, Map<String, String> headers) {
        return call(path, params, headers, GET);
    }

    /**
     * 发出带着请求路径、请求参数、请求首部的POST请求
     * @param path 请求路径
     * @param params 请求参数
     * @param headers 请求首部
     * @return 调用结果
     */
    default IResult<T> post(String path, Map<String, String> params, Map<String, String> headers) {
        return call(path, params, headers, POST);
    }
}

