/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

/**
 *
 * @author Dumi
 */
public class Mayor {
    
    private Integer id;
    private String name;
    private Integer age;

    public Mayor() {
    }

    public Mayor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Mayor(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Mayor{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }
    
    
}
