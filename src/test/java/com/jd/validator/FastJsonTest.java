package com.jd.validator;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Map;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-05 11:02
 */
public class FastJsonTest {

    @Test
    public void testStrToObj() {
        String json = "{\"id\":111, \"name\":\"zhansan\"}";
        JSONObject jsonObject = JSON.parseObject(json);

        Object id = jsonObject.get("id");
        System.out.println("id=============" + id);

        Student student1 = JSON.toJavaObject(jsonObject, Student.class);
        System.out.println(student1);
    }

    @Test
    public void testStrToObj2() {
        String json = "{\"id\":111, \"name\":\"zhansan\"}";

        Student student1 = JSON.parseObject(json, Student.class);
        System.out.println(student1);
    }


    @Test
    public void testStrToMap() {
        String json = "{\"id\":111, \"name\":\"zhansan\"}";

        Map map = JSON.parseObject(json, Map.class);
        System.out.println(map);
    }

}


class Student {
    private int id;
    private String name;

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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}