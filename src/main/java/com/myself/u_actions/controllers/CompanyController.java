package com.myself.u_actions.controllers;

import com.myself.u_actions.models.Company;
import com.myself.u_actions.services.CompanyServices.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
