package com.sourabh.bean;

import java.util.List;

public class Contact {
    private String name;
    private List<Integer> numbers;
    public Contact(){}

    public Contact(String name, List<Integer> numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", numbers=" + numbers +
                '}';
    }
}
