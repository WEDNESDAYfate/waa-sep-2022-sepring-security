package edu.miu.demo.service;


import edu.miu.demo.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();

    ReviewDto create(ReviewDto reviewDto);

    ReviewDto findById(int id);

    void delete(int id);
}
