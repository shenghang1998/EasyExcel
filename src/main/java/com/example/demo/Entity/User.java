package com.example.demo.Entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.metadata.BaseRowModel;

// 表示列宽
@ColumnWidth(20)
public class User extends BaseRowModel {

    // index--表示属性在第几列，value--表示标题
    @ExcelProperty(value = "id", index = 0)
    private int id;

    @ExcelProperty(value = "name", index = 1)
    private String name;

    @ExcelProperty(value = "age", index = 2)
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}