package com.example.orders.model.request;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    @NotBlank
    private String customerName;

    @NotBlank
    private String productCode;

    @NotNull
    private Integer quantity;

    @NotBlank
    private String status;
}
