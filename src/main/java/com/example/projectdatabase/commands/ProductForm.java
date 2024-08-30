package com.example.projectdatabase.commands;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by jt on 1/10/17.
 */
@Setter @Getter
public class ProductForm {
    private Long id;
    private String description;
    private BigDecimal price;
    private String imageUrl;

}
