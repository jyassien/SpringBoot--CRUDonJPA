package com.example.botanistJPA.entities;
/*
* Spring Data JPA is an abstraction layer that allows us to
* interact with objects in your code rather than write SQL queries.
* These objects, in this context, are referred to as models (or entities).
* Typically, we write Java classes and use annotations to identify them as
* models to Spring Data JPA. Then, Spring Data JPA sends instructions to the
* Hibernate ORM to execute the correct SQL statements depending on the methods
* that we’ve called on our model and the annotations we’ve put on its fields.
*  model corresponds to a database table, and a field in a model corresponds to a column in that table.
* */
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(name="PLANTS")
public class Plant{

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "WATERING_FREQUENCY")
    private Integer wateringFrequency;
    @Column(name = "HAS_FRUIT")
    private Boolean hasFruit;

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getQuantity(){
        return this.quantity;
    }
    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
    public Integer getWateringFrequency(){
        return this.wateringFrequency;
    }
    public void setWateringFrequency(Integer wateringFrequency){
        this.wateringFrequency = wateringFrequency;
    }
    public Boolean getHasFruit(){
        return this.hasFruit;
    }
    public void setHasFruit(Boolean hasFruit){
        this.hasFruit = hasFruit;
    }

}


/*
* all the required annotations that define the translation between our POJO and our database relation:

* @Entity: tells the ORM that this model will be used to represent a table or relation in our database
* @Table: tells the ORM what table name in the underlying database that this model corresponds to.
*  Here, it is used to say that the Person entity represents a single entry in the "PEOPLE"
* table of the underlying database.
* @Id: tells the ORM that this field (id) will be used to uniquely identify a single entry in our "PEOPLE" relation
* @GeneratedValue: tells the ORM that the developer will not be supplying the value for this field themselves.
*  Instead, it should be “auto-generated” by the database. Typically, an @Id field for an entity will
* be auto-generated in this way, so that we can leverage the database to guarantee that the ID will always be unique.
* @Column: tells the ORM what column in the underlying relation that the annotated field corresponds to.
*  For example, the eyeColor field of our entity corresponds to the "EYE_COLOR" column in the "PEOPLE" relation.
*
* When the ORM interacts with your model, it depends on “getter” and “setter” methods
* that have been appropriately named based on the fields.
* */