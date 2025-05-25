package com.example.products.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class CreateProductRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @JsonProperty("country")
    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Visible is required")
    private Boolean visible;

}
