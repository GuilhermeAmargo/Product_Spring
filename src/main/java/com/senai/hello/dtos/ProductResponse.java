package com.senai.hello.dtos;

public record ProductResponse(
    Long id,
    String name,
    Double price
) {
	
}
