package com.fanhehe.httputil.result;

import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

/**
 * Created by fanhehe on 16/07/2019.
 * reference https://juejin.im/entry/5b5e6bb7e51d45195312803a
 */
public class ParameterizedTypeImpl implements ParameterizedType {

    private final Class raw;
    private final Type[] args;

    public ParameterizedTypeImpl(Class raw, Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
    }

    @Override
    public Type getOwnerType() {
        return null;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }

    @Override
    public Type getRawType() {
        return raw;
    }
}
