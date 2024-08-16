package com.thisavik.jobapp.review.impl;

import com.thisavik.jobapp.company.Company;
import com.thisavik.jobapp.company.CompanyService;
import com.thisavik.jobapp.review.Review;
import com.thisavik.jobapp.review.ReviewRepository;
import com.thisavik.jobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;
    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }


    @Override
    public List<Review> getAllReviewsByCompany(Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null)
            return reviewRepository.findByCompanyId(companyId);
        return null;
    }

    @Override
    public boolean addReviewByCompany(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }
}