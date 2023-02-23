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
public class Place {
    
    private Integer id;
    private String name;
    private Integer population;
    private Mayor mayor;

    public Place() {
    }

    public Place(Integer id, String name, Integer population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public Place(Integer id, String name, Integer population, Mayor mayor) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.mayor = mayor;
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

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Mayor getMayor() {
        return mayor;
    }

    public void setMayor(Mayor mayor) {
        this.mayor = mayor;
    }

    @Override
    public String toString() {
        return "Place{" + "id=" + id + ", name=" + name + ", population=" + population + ", mayor=" + mayor + '}';
    }
    
    
}
