package com.simple.serializer;

/**
 * User: tanhuayou
 * Date: 2018/8/6
 */
public interface Serializer<T> {

    byte[] serialize(T obj);

    T deserialize(byte[] bytes);
}
