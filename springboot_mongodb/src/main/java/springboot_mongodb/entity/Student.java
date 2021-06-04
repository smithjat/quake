package springboot_mongodb.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private String stuName;
    private Integer age;

    public Student() {
    }

    public Student(String stuName, Integer age) {
        this.stuName = stuName;
        this.age = age;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}