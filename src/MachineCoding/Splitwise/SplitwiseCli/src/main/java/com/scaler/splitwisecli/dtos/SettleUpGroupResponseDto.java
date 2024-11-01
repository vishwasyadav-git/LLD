package com.scaler.splitwisecli.dtos;

import com.scaler.splitwisecli.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    List<Expense> expenses;
    private ResponseStatus responseStatus;
}
