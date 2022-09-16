package edu.miu.demo.dto;

import edu.miu.demo.model.Category;
import lombok.Data;

@Data
public class CategoryDto {
    private int id;
    private String name;

    public CategoryDto toDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    public Category toEntity() {
        Category category = new Category();
        category.setId(this.id);
        category.setName(this.name);
        return category;
    }

}
