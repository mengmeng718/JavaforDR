package com.neusoft.springbootsell.form;

import lombok.Data;

@Data
public class ProductFormTwo {

    private String productId;

    private String productName;

    private Integer productStock;

    private Integer productStatus;
}