package com.decagon.phila.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product_size")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Size extends BaseModel{

    private String size;
}
