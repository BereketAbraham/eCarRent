package mum.edu.cs.cs425.project.ecarrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import mum.edu.cs.cs425.project.ecarrent.services.IVehicleService;

@Controller
public class VehicleController {
	
	@Autowired
    private IVehicleService vehicleService;

}