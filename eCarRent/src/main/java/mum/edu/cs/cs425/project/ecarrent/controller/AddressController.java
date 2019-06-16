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
import mum.edu.cs.cs425.project.ecarrent.model.Address;
import mum.edu.cs.cs425.project.ecarrent.model.Vehicle;
import mum.edu.cs.cs425.project.ecarrent.services.IAddressService;

@Controller
public class AddressController {
	
	@Autowired
	private IAddressService addressService;
	
	@GetMapping(value = "/company/user/addresses/add")
    public String newAddressForm(Model model) {
		Address newAddress = new Address();
        model.addAttribute("address", newAddress);
        return "user/addresses/addressform";
    }
	
	@PostMapping(value = "/company/user/addresses/add/save")
    public String addNewAddress(@Valid @ModelAttribute("address") Address address,
        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "user/addresses/addressform";
        }
        address = addressService.save(address);
        return "redirect:/general/underconstruction";
    }
	
	@GetMapping(value = "/company/user/addresses/edit/{addressId}")
    public String editAddressForm(@PathVariable("addressId") Long addressId, Model model) {
		Address address = addressService.findById(addressId);
        if (address != null) {
            model.addAttribute("address", address);
            return "user/addresses/addressform";
        }
        return "redirect:/general/underconstruction";
    }
	
	@GetMapping(value="/company/user/addresses/delete/{addressId}")
	public String deleteAddress(@PathVariable("addressId") Long id, Model model){		
		addressService.delete(id);
		return "redirect:/general/underconstruction";
	}
	
}
