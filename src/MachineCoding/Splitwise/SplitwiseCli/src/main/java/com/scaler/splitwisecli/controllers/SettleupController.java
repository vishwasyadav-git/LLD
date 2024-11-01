package com.scaler.splitwisecli.controllers;

import com.scaler.splitwisecli.dtos.*;
import com.scaler.splitwisecli.models.Expense;
import com.scaler.splitwisecli.services.SettleUpService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleupController {
    private SettleUpService settleUpService;
    public SettleupController(SettleUpService settleUpService){
        this.settleUpService=settleUpService;
    }
    /*
     settle up functionality should return the list of transaction
     which when executed will make net amount of the user zero
     */
   public SettleupResponseDto settleUpuser(SettleUpUserRequestDto requestDto){
        SettleupResponseDto responseDto=new SettleupResponseDto();

        try {
            List<Expense>  expenses=settleUpService.settleUpUser(requestDto.getUserId());

            responseDto.setExpenses(expenses);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        return responseDto;

     }


    public    SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto requestDto){
        return null;
       }
}
