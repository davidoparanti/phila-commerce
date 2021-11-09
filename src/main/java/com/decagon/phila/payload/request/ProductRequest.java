package com.decagon.phila.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;

    private double price;

    private String description;

    private List<String> category;

    private List<String> subCategory;

    private List<String> sizes;

    private List<String> colors;

    private List<String> productImages;

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

}
