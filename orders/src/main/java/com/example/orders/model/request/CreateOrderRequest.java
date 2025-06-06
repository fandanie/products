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

    @NotNull
    private Long id;

    @NotNull
    private Integer quantity;

}
