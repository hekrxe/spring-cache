package com.simple.serializer;

import com.alibaba.fastjson.JSON;
import com.simple.model.DataObject;

import java.util.ArrayList;
import java.util.List;

/**
 * User: tanhuayou
 * Date: 2018/8/6
 */
public class Test {
    public static void main(String[] args) {
        ProtostuffRedisSerializer serializer = new ProtostuffRedisSerializer();
        List<DataObject> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list.add(DataObject.buildOne());
        }

        long t1 = System.currentTimeMillis();
        byte[] proBytes = serializer.serialize(list);
        long t2 = System.currentTimeMillis();
        List<DataObject> proDes = (List<DataObject>) serializer.deserialize(proBytes);
        long t3 = System.currentTimeMillis();
//=====================
        String json = JSON.toJSONString(list);
        long t4 = System.currentTimeMillis();
        List<DataObject> list1 = JSON.parseArray(json, DataObject.class);
        long t5 = System.currentTimeMillis();

        System.out.println("proto serialize: " + (t2 - t1));
        System.out.println("proto deserialize: " + (t3 - t2));
        System.out.println("json ser: " + (t4 - t3));
        System.out.println("json des: " + (t5 - t4));

        System.out.println("========");
        System.out.println(proDes);
        System.out.println(list1);
        System.out.println(proDes.get(0).getTimestamp());
    }
}
