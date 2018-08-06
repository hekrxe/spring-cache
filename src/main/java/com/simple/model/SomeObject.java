package com.simple.model;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * User: tanhuayou
 * Date: 2018/8/6
 */
public class SomeObject {
    protected static Random random = new Random();

    private String username;
    private String nickName;
    private Integer age;
    private String password;
    private String address;
    private String email;
    private Integer high;

    public static <T extends SomeObject> T fill(T obj) {
        obj.setUsername(nextString()).setNickName(nextString()).setPassword(nextString())
                .setAddress(nextString()).setEmail(nextString())
                .setAge((int) nextNumber()).setHigh((int) nextNumber());
        return obj;
    }

    public static long nextNumber() {
        return Long.valueOf(RandomStringUtils.randomNumeric(Math.abs(random.nextInt() % 16) + 1));
    }

    public static String nextString() {
        return RandomStringUtils.randomAlphanumeric(Math.abs(random.nextInt() % 20) + 1);
    }

    public String getUsername() {
        return username;
    }

    public SomeObject setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public SomeObject setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public SomeObject setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SomeObject setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SomeObject setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SomeObject setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getHigh() {
        return high;
    }

    public SomeObject setHigh(Integer high) {
        this.high = high;
        return this;
    }


}
