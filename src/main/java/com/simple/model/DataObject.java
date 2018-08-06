package com.simple.model;

import com.alibaba.fastjson.JSON;

import java.sql.Timestamp;
import java.util.*;

/**
 * User: tanhuayou
 * Date: 2018/8/6
 */
public class DataObject extends SomeObject {
    private boolean booleanOf;
    private byte byteOf;
    private char charOf;
    private int intOf;
    private short shortOf;
    private float floatOf;
    private double doubleOf;
    private long longOf;

    private Boolean boolObj;
    private Byte byteObj;
    private String str;
    private Integer integer;
    private Short shortObj;
    private Float floatObj;
    private Double doubleObj;
    private Long longObj;
    private Date date;
    private Timestamp timestamp;

    private Set<Long> set;
    private List<SomeObject> someObjects;


    public static DataObject buildOne() {
        DataObject dataObject = new DataObject();
        dataObject.setBooleanOf(nextNumber() % 2 == 0).setByteOf((byte) nextNumber())
                .setCharOf((char) nextNumber()).setShortOf((short) nextNumber())
                .setFloatOf((float) nextNumber()).setDoubleOf((double) nextNumber())
                .setLongOf(nextNumber()).setIntOf((int) nextNumber())
                .setBoolObj(nextNumber() % 2 == 1).setByteObj((byte) nextNumber())
                .setStr(nextString()).setInteger((int) nextNumber())
                .setShortObj((short) nextNumber()).setFloatObj((float) nextNumber())
                .setDoubleObj((double) nextNumber()).setLongObj(nextNumber())
                .setSet(buildSet()).setSomeObjects(buildList())
                .setDate(new Date()).setTimestamp(new Timestamp(System.currentTimeMillis()));

        return SomeObject.fill(dataObject);
    }


    public static Set<Long> buildSet() {
        int size = Math.abs(random.nextInt() % 30) + 50;
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < size; ++i) {
            set.add(nextNumber());
        }
        return set;
    }


    public static List<SomeObject> buildList() {
        int size = Math.abs(random.nextInt() % 30) + 50;
        List<SomeObject> list = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            list.add(SomeObject.fill(new SomeObject()));
        }
        return list;
    }


    public boolean isBooleanOf() {
        return booleanOf;
    }

    public DataObject setBooleanOf(boolean booleanOf) {
        this.booleanOf = booleanOf;
        return this;
    }

    public byte getByteOf() {
        return byteOf;
    }

    public DataObject setByteOf(byte byteOf) {
        this.byteOf = byteOf;
        return this;
    }

    public char getCharOf() {
        return charOf;
    }

    public DataObject setCharOf(char charOf) {
        this.charOf = charOf;
        return this;
    }

    public int getIntOf() {
        return intOf;
    }

    public DataObject setIntOf(int intOf) {
        this.intOf = intOf;
        return this;
    }

    public short getShortOf() {
        return shortOf;
    }

    public DataObject setShortOf(short shortOf) {
        this.shortOf = shortOf;
        return this;
    }

    public float getFloatOf() {
        return floatOf;
    }

    public DataObject setFloatOf(float floatOf) {
        this.floatOf = floatOf;
        return this;
    }

    public double getDoubleOf() {
        return doubleOf;
    }

    public DataObject setDoubleOf(double doubleOf) {
        this.doubleOf = doubleOf;
        return this;
    }

    public long getLongOf() {
        return longOf;
    }

    public DataObject setLongOf(long longOf) {
        this.longOf = longOf;
        return this;
    }

    public Boolean getBoolObj() {
        return boolObj;
    }

    public DataObject setBoolObj(Boolean boolObj) {
        this.boolObj = boolObj;
        return this;
    }

    public Byte getByteObj() {
        return byteObj;
    }

    public DataObject setByteObj(Byte byteObj) {
        this.byteObj = byteObj;
        return this;
    }

    public String getStr() {
        return str;
    }

    public DataObject setStr(String str) {
        this.str = str;
        return this;
    }

    public Integer getInteger() {
        return integer;
    }

    public DataObject setInteger(Integer integer) {
        this.integer = integer;
        return this;
    }

    public Short getShortObj() {
        return shortObj;
    }

    public DataObject setShortObj(Short shortObj) {
        this.shortObj = shortObj;
        return this;
    }

    public Float getFloatObj() {
        return floatObj;
    }

    public DataObject setFloatObj(Float floatObj) {
        this.floatObj = floatObj;
        return this;
    }

    public Double getDoubleObj() {
        return doubleObj;
    }

    public DataObject setDoubleObj(Double doubleObj) {
        this.doubleObj = doubleObj;
        return this;
    }

    public Long getLongObj() {
        return longObj;
    }

    public DataObject setLongObj(Long longObj) {
        this.longObj = longObj;
        return this;
    }


    public Set<Long> getSet() {
        return set;
    }

    public DataObject setSet(Set<Long> set) {
        this.set = set;
        return this;
    }

    public List<SomeObject> getSomeObjects() {
        return someObjects;
    }

    public DataObject setSomeObjects(List<SomeObject> someObjects) {
        this.someObjects = someObjects;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public DataObject setDate(Date date) {
        this.date = date;
        return this;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public DataObject setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
