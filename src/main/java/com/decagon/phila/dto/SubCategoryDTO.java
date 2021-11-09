package com.decagon.phila.dto;

import com.decagon.phila.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubCategoryDTO {

    private String name;

    private Category category;

}
