package com.example.demo.endpoints.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
public class SettleBalanceDTO {
    @NotNull
    @NotEmpty
    private Long groupID;
}
