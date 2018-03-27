package com.example.magneto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.magneto.domain.DnaSequence;
import com.example.magneto.service.MagnetoService;
import com.example.magneto.service.MagnetoServiceImpl;

/**
 * Web Controller
 *
 */
@RestController
@RequestMapping("/mutant")
public class Controller {

	MagnetoService service = new MagnetoServiceImpl();

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> post(@RequestBody DnaSequence dna) {
		ResponseEntity response;
		try {
			if (service.isMutant(dna.getDna())) {
				response = ResponseEntity.ok("Is mutant!");
			} else {
				response = ResponseEntity.status(403).build();
			}
		} catch (Exception e) {
			response = ResponseEntity.status(403).build();
		}

		return response;
	}

}
