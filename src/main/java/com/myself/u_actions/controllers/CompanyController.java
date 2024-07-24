package com.myself.u_actions.controllers;

import com.myself.u_actions.models.Company;
import com.myself.u_actions.services.CompanyServices.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/getAll")
    ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok().body(companyService.getAllCompanies());
    }

    @GetMapping("/getByName")
    ResponseEntity<Company> getCompanyByName(@RequestParam String name) {
        return ResponseEntity.ok().body(companyService.getCompanyByName(name));
    }

    @PostMapping("/create")
    ResponseEntity<Object> createCompany(@RequestParam String name, @RequestParam String location, @RequestParam String identifier, @RequestParam String sector, @RequestParam double valuation) {

        String companyName = companyService.getCompanyByName(name).getClass().getName();
        if(name.isEmpty()) {
            return new ResponseEntity<>("Name cannot be empty", HttpStatus.BAD_REQUEST);
        }
        if(!companyName.isEmpty()) {
            return new ResponseEntity<>(String.format("Company with name %s already exists", name), HttpStatus.BAD_REQUEST);
        }
        if(location.isEmpty()) {
            return new ResponseEntity<>("Location cannot be empty", HttpStatus.BAD_REQUEST);
        }
        if(identifier.isEmpty()) {
            return new ResponseEntity<>("Identifier cannot be empty", HttpStatus.BAD_REQUEST);
        }
        if(sector.isEmpty()) {
            return new ResponseEntity<>("Sector cannot be empty", HttpStatus.BAD_REQUEST);
        }
        if(valuation <= 0) {
            return new ResponseEntity<>("Valuation cannot be 0 or negative", HttpStatus.BAD_REQUEST);
        }
        companyService.createCompany(name, location, identifier, sector, valuation);
        return new ResponseEntity<>("Company created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{name}")
    ResponseEntity<Object> deleteCompany(@PathVariable String name) {
        if(name.isEmpty()) {
            return new ResponseEntity<>("Name cannot be empty", HttpStatus.BAD_REQUEST);
        }
        companyService.deleteCompanyByName(name);
        return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
    }
}
