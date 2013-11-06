package com.mycompany.hibernate.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 */

@NamedQueries({
        @NamedQuery(
                name = "getExampleEntities",
                query = "SELECT e FROM ExampleEntity e"
        ),

        @NamedQuery(
                name = "getExampleByName",
                query = "SELECT e FROM ExampleEntity e WHERE e.name = :name"
        ),

        @NamedQuery(
                name = "countExampleEntities",
                query = "SELECT COUNT(e) FROM ExampleEntity e"
        )
})


@XmlRootElement(name = "example", namespace = "urn:entities.hibernate.mycompany.com")
@Entity
@Table(name="example")
public class ExampleEntity extends Example{
    @Override
    @Column(name = "project_name")
    public String getName() {
        return name;
    }

    @Override
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @XmlTransient
    @Column(name = "project_id")
    public int getId() {
        return id;
    }

    @Override
    @Column(name = "project_current")
    public long getUploaded() {
        return uploaded;
    }
}
