package nl.schild.ruben.RubenfirstAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Garage
{
    @Id
    @GeneratedValue
    private long id;

    public Garage()
    {

    }
}
