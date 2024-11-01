package com.scaler.splitwisecli.strategy;

import com.scaler.splitwisecli.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
}
