package com.myself.u_actions.services.CompanyServices;

import com.myself.u_actions.models.Company;
import com.myself.u_actions.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImplement implements CompanyService{
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyByName(String name) {
        return companyRepository.findByName(name)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found with name: " + name));
    }
}
