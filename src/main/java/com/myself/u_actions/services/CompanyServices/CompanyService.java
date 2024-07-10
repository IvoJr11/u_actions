package com.myself.u_actions.services.CompanyServices;

import com.myself.u_actions.models.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyByName(String name);
}
