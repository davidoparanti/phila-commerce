package com.decagon.phila.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product_images")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage extends BaseModel{
      ;
        private String image;

}
