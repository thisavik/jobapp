package com.thisavik.jobapp.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void saveCompany(Company company);

    Company getCompanyById(Long id);

    boolean updateCompanyById(Long id, Company company);

    boolean removeCompanyById(Long id);
}
