package org.example.domain.service;

import org.example.domain.DAO.PlantDAO;
import org.example.domain.model.Plant;

import java.sql.SQLException;
import java.util.List;

public class PlantService {

    private final PlantDAO plantDAO;

    public PlantService(PlantDAO plantDAO) {
        this.plantDAO = plantDAO;
    }

    public boolean addPlant(Plant plant) throws SQLException {
        if (plantDAO.getPlantByCode(plant.getCode()) != null) {
            throw new IllegalArgumentException("Plant code must be unique.");
        }
        if (plant.getDescription() != null && plant.getDescription().length() > 10) {
            throw new IllegalArgumentException("Description must not exceed 10 characters.");
        }
        plantDAO.insertPlant(plant);
        return false;
    }

    public void updatePlant(Plant plant) throws SQLException {
        Plant existingPlant = plantDAO.getPlantByCode(plant.getCode());
        if (existingPlant == null) {
            throw new IllegalArgumentException("Plant not found.");
        }
        plantDAO.updatePlant(plant);
    }

    public boolean deletePlant(int code, boolean isAdmin) throws SQLException {
        if (!isAdmin) {
            throw new SecurityException("Only admin users can delete plants.");
        }
        plantDAO.deletePlant(code);
        return isAdmin;
    }

    public List<Plant> listPlants() throws SQLException {
        return plantDAO.getAllPlants();
    }
}
