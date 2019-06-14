package mum.edu.cs.cs425.project.ecarrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import mum.edu.cs.cs425.project.ecarrent.services.ICredentialService;

@Controller
public class CredentialController {
	
	@Autowired
    private ICredentialService credentialService;

}