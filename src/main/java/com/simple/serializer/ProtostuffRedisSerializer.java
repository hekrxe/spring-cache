package com.simple.serializer;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.DefaultIdStrategy;
import io.protostuff.runtime.Delegate;
import io.protostuff.runtime.RuntimeEnv;
import io.protostuff.runtime.RuntimeSchema;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.sql.Timestamp;

/**
 * User: tanhuayou
 * Date: 2018/8/6
 */
public class ProtostuffRedisSerializer implements RedisSerializer<Object> {
    private static final byte[] EMPTY = new byte[0];

    private final static Delegate<Timestamp> TIMESTAMP_DELEGATE = new TimestampDelegate();
    private final static DefaultIdStrategy ID_STRATEGY = ((DefaultIdStrategy) RuntimeEnv.ID_STRATEGY);

    static {
        ID_STRATEGY.registerDelegate(TIMESTAMP_DELEGATE);
    }


    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (null == o) {
            return EMPTY;
        }
        ObjectWrapper wrapper = new ObjectWrapper().setTarget(o);
        // 内部不会重新创建
        Schema<ObjectWrapper> schema = RuntimeSchema.getSchema(ObjectWrapper.class);
        LinkedBuffer buffer = LinkedBuffer.allocate();
        try {
            return ProtostuffIOUtil.toByteArray(wrapper, schema, buffer);
        } finally {
            buffer.clear();
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (null == bytes || bytes.length <= 0) {
            return null;
        }
        Schema<ObjectWrapper> schema = RuntimeSchema.getSchema(ObjectWrapper.class);
        ObjectWrapper message = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(bytes, message, schema);

        return message.getTarget();
    }

    /**
     * 中间层为了拿到 schema
     */
    private static class ObjectWrapper {
        private Object target;

        ObjectWrapper() {
        }

        public Object getTarget() {
            return target;
        }

        public ObjectWrapper setTarget(Object target) {
            this.target = target;
            return this;
        }
    }
}
