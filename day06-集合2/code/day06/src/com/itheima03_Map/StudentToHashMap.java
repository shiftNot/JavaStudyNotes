package com.itheima03_Map;

public class StudentToHashMap {
    String name;
    int age;


    public StudentToHashMap(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentToHashMap that = (StudentToHashMap) o;

        if (age != that.age) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "StudentToHashMap{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
