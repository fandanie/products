package com.example.products.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class CreateProductRequest {

    @JsonProperty("name")
    @NotBlank(message = "Name is required")
    private String name;

    @JsonProperty("price")
    @NotBlank(message = "Price is required")
    private BigDecimal price;

    @JsonProperty("stock")
    @NotBlank(message = "Stock is required")
    private Integer stock;

    @JsonProperty("company")
    @NotBlank(message = "Company is required")
    private String company;

    @JsonProperty("shortDescription")
    private String shortDescription;

    @JsonProperty("longDescription")
    private String longDescription;

    @JsonProperty("imageUrl")
    private String imageUrl;


}
