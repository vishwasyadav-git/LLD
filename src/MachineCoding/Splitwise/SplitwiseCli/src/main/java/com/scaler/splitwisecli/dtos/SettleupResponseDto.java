package com.scaler.splitwisecli.dtos;

import com.scaler.splitwisecli.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SettleupResponseDto {
    List<Expense> expenses;
    private  ResponseStatus responseStatus;

}
