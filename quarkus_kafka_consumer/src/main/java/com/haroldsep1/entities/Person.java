package com.haroldsep1.entities;

public class Person {
    
    private Long id;
    private String fullName;
    private Short age;
    
    public Person() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public Short getAge() {
        return age;
    }
    
    public void setAge(Short age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                "}\n";
    }
}
