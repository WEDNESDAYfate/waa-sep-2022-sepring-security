package edu.miu.demo.service;


import edu.miu.demo.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    void create(CategoryDto categoryDto);

    void delete(int id);

    CategoryDto getById(int id);
}
