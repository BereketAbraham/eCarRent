package mum.edu.cs.cs425.project.ecarrent.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import mum.edu.cs.cs425.project.ecarrent.model.Category;
import mum.edu.cs.cs425.project.ecarrent.model.Vehicle;
import mum.edu.cs.cs425.project.ecarrent.services.IVehicleService;

@Controller
public class VehicleController {
	
	@Autowired
    private IVehicleService vehicleService;
	
	@GetMapping(value = "/company/admin/vehicles")
    public ModelAndView manageVehicles() {
        ModelAndView modelAndView = new ModelAndView();
        List<Vehicle> vehicles = vehicleService.findAll();
        modelAndView.addObject("vehicles", vehicles);
        modelAndView.setViewName("admin/vehicles/vehicles");
        return modelAndView;
    }
	
	@GetMapping(value = "/company/admin/vehicles/add")
    public String newVehicleForm(Model model) {
		Vehicle newVehicle = new Vehicle();
		newVehicle.setVehicleNumber(vehicleService.assignVehicleNumber());
        model.addAttribute("vehicle", newVehicle);
        return "admin/vehicles/newvehicleform";
    }
	
	@PostMapping(value = "/company/admin/vehicles/add/save")
    public String addNewVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle,
        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/vehicles/newvehicleform";
        }
        vehicle = vehicleService.save(vehicle);
        return "redirect:/company/admin/vehicles";
    }
	
	@GetMapping(value = "/company/admin/vehicles/edit/{vehicleId}")
    public String editVehicleForm(@PathVariable("vehicleId") Long vehicleId, Model model) {
		Vehicle vehicle = vehicleService.findById(vehicleId);
        if (vehicle != null) {
            model.addAttribute("vehicle", vehicle);
            return "admin/vehicles/editvehicleform";
        }
        return "admin/vehicles/vehicles";
    }
	
	@GetMapping(value="/company/admin/vehicles/delete/{vehicleId}")
	public String deleteVehicle(@PathVariable("vehicleId") Long id, Model model){		
		vehicleService.delete(id);
		return "redirect:/company/admin/vehicles";
	}
	
}