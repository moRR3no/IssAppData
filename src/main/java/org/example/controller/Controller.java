package org.example.controller;

import org.example.model.SpaceCrew;
import org.example.service.Service;

public class Controller {

    private Service service = new Service();

    public Controller() {
    }

    public String getLocation() {
        return service.getLocation().toString();
    }

    public String getSpaceCrew() {
        StringBuilder sb = new StringBuilder();
        for (SpaceCrew s : service.getSpaceCrew()) {
            sb.append("id: ").append(s.getId()).append(", ").append(s.getName()).append(", ").append(s.getCraft()).append(" || ");
        }
        return sb.toString();
    }

}
