package com.scaler.splitwisecli.strategy;

import com.scaler.splitwisecli.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class HeapSettleUpStrategy implements  SettleUpStrategy{

    @Override
    public List<Expense> settleUp(List<Expense> expenses) {

        //To Do
        return null;
    }
}
