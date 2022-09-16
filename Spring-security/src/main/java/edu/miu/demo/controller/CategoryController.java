package edu.miu.demo.controller;


import edu.miu.demo.dto.CategoryDto;
import edu.miu.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @PostMapping
    public void create(@RequestBody CategoryDto categoryDto) {
        categoryService.create(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable int id) {
        return categoryService.getById(id);
    }
}
