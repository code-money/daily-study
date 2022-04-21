package com.zyz.jdbc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Count {
    private int id;
    private String name;
    private int blance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlance() {
        return blance;
    }

    public void setBlance(int blance) {
        this.blance = blance;
    }

    @Override
    public String toString() {
        return "Count{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blance=" + blance +
                '}';
    }
}
