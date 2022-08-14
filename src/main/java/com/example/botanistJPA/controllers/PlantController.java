package com.example.botanistJPA.controllers;
/*
 * When a user wishes to interact with your API, they do so by making REST calls to a RestController.
 *  A RestController is used as the layer of the application that takes requests from the user and
 * accordingly sends commands to the repository or data access layer to accomplish what task the user
 * requested in their REST call.

 * The repository must be a dependency of the controller, and you can make the repository bean available
 * to the controller class using dependency injection.
 *
 * */
import com.example.botanistJPA.entities.Plant;
import com.example.botanistJPA.repository.PlantRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;




import java.lang.Iterable;
import java.util.Optional;
/*
* To make a bean available to a class that depends on it, you can simply
* add it as a field of the class and include it in the constructor.
* Spring Boot will automatically “wire” in the dependency when it
* discovers the dependency in the Spring context.
*
* */

@RestController
public class PlantController {

    private final PlantRepository plantRepository;

    public PlantController(final PlantRepository plantRepository){
        this.plantRepository = plantRepository;
    }

    @GetMapping("/plants")
    public Iterable<Plant> getAllPlants(){
        return this.plantRepository.findAll();
    }

    @GetMapping("/plants/{id}")
    public Optional<Plant> getPlantById(@PathVariable("id") Integer id){
        return this.plantRepository.findById(id);
    }
    @PostMapping("/addplant")
    public Plant createNewPlant(@RequestBody Plant plant ){
        Plant newPlant = this.plantRepository.save(plant);
        return newPlant;
    }

    @PutMapping("/updataplant?/{id}")
    public Plant updatePlant(@PathVariable("id") Integer id, @RequestBody Plant plant){
        Optional<Plant> plantToUpdateOptional = this.plantRepository.findById(id);
        if(!plantToUpdateOptional.isPresent()){
            return null;
        }
        Plant plantToUpdate = plantToUpdateOptional.get();


        if (plant.getName() != null) {
            plantToUpdate.setName(plant.getName());
        }
        if(plant.getQuantity() != null){
            plantToUpdate.setQuantity(plant.getQuantity());
        }
        if(plant.getWateringFrequency() != null){
            plantToUpdate.setWateringFrequency(plant.getWateringFrequency());
        }
        if(plant.getHasFruit() != null){
            plantToUpdate.setHasFruit(plant.getHasFruit());
        }

        Plant updatedPlant = this.plantRepository.save(plantToUpdate);

        return updatedPlant;

    }

    @DeleteMapping("/deleteplant/{id}")
    public Plant deletePlant(@PathVariable("id") Integer id) {
        Optional<Plant> plantToDeleteOptional = this.plantRepository.findById(id);
        if(!plantToDeleteOptional.isPresent()){
            return null;
        }
        Plant plantToDelete = plantToDeleteOptional.get();

        this.plantRepository.delete(plantToDelete);

        return plantToDelete;
    }




}


