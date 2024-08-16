package com.thisavik.jobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsByCompany(Long companyId);

    boolean addReviewByCompany(Long companyId, Review review);
}