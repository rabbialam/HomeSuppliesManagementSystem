package com.example.demo.endpoints.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SettleBalanceDTO {
    @NotNull
    @NotEmpty
    private Long groupID;
}
