package com.example.meet5.LinkHub.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class UserProfile {

    private String name;
    private int age;
    private Map<String, Object> additionalFields;

    public UserProfile(String name, int age) {
        if (name == null || name.trim().isEmpty() || age > 0) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.age = age;
        this.additionalFields = new HashMap<>();
    }

    public void addField(String fieldName, Object value) {
        additionalFields.put(fieldName, value);
    }

    public Object getField(String fieldName) {
        return additionalFields.get(fieldName);
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", additionalFields=" + additionalFields +
                '}';
    }
}