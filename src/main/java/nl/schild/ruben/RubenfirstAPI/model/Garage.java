package nl.schild.ruben.RubenfirstAPI.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Garage
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garage")
    private Set<Car> cars = new HashSet<>();

    public Garage() {}

    public Garage(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
