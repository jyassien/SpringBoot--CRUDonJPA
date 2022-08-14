
package com.example.botanistJPA.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.botanistJPA.entities.Plant;


public interface PlantRepository extends CrudRepository<Plant, Integer>{

}

/*
* Spring Data JPA uses repositories to accomplish this.
* A repository is a data access and manipulation layer that wraps around your data model.
* A repository will come with methods to call on instances of your data model like .save(),
* or .findAll(), or .findById(), enabling a no-code solution to interacting with
* a data model in a Spring Boot application.
*
* Spring Data JPA comes with a special kind of repository interface that gives you full
*  CRUD functionality for your model. To use it, an application developer
* simply imports the repository interface, tells it what model it should wrap around, and it is good to use!
* */