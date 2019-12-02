package com.example.demo.endpoints.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EnterAmountDTO {
    @NotNull
    private double amount;

    @NotNull
    private Long groupId;

}
