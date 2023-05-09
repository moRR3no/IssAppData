package org.example.service;

import org.example.DAO.ISSLocationDAO;
import org.example.DAO.SpaceCrewDAO;
import org.example.model.ISSLocation;
import org.example.model.ISSVelocity;
import org.example.model.SpaceCrew;
import org.example.utils.JsonOperations;
import org.example.utils.SpeedCalculator;

public class Service {

    private final JsonOperations jsonOperations;
    private final ISSLocationDAO issLocationDAO;
    private final SpaceCrewDAO spaceCrewDAO;
    private final SpeedCalculator speedCalculator;
    private ISSLocation currentLocation;
    private ISSVelocity issVelocity;
    private SpaceCrew[] spaceCrew;


    public Service() {
        jsonOperations = new JsonOperations();
        issLocationDAO = new ISSLocationDAO();
        spaceCrewDAO = new SpaceCrewDAO();
        speedCalculator = new SpeedCalculator();

        currentLocation = jsonOperations.getLocation();
        issLocationDAO.create(currentLocation);
    }

    public ISSLocation getLocation() {
        currentLocation = jsonOperations.getLocation();
        issVelocity = speedCalculator.calculateSpeed(issLocationDAO.loadNthFromEndISSLocation(10),currentLocation);
        currentLocation.setVelocity(issVelocity);
        issLocationDAO.create(currentLocation);
        return currentLocation;
    }


    public SpaceCrew[] getSpaceCrew() {
        spaceCrew = jsonOperations.getSpaceCrew();
        spaceCrewDAO.create(spaceCrew);
        return spaceCrew;
    }


    public boolean validateInputLat(String inputLat) {
        int input;
        try {
            input = Integer.parseInt(inputLat);
        } catch (NumberFormatException e) {
            return false;
        }
        return input >= -80 && input <= 80;
    }

    public boolean validateInputAlt(String inputAlt) {
        int input;
        try {
            input = Integer.parseInt(inputAlt);
        } catch (NumberFormatException e) {
            return false;
        }
        return input >= -180 && input <= 180;
    }
}
