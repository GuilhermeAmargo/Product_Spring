package com.senai.hello.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductRequest(
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters") 
    String name,

    @Min(value = 0, message = "Price must be greater than or equal to 0")
    Double price
) {
    
}
