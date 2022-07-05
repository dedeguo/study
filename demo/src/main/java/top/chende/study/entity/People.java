package top.chende.study.entity;

import java.io.Serializable;

public class People implements Serializable {

    String id;
    String name;
    String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public People(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public People() {
    }
}
