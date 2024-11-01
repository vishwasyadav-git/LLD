package com.scaler.splitwisecli.commands;

import com.scaler.splitwisecli.controllers.SettleupController;
import com.scaler.splitwisecli.dtos.SettleUpUserRequestDto;
import com.scaler.splitwisecli.dtos.SettleupResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SettleUpUserCommand implements Command{
    private SettleupController settleupController;

    public SettleUpUserCommand(SettleupController settleupController){
        this.settleupController=settleupController;
    }
    @Override
    public void execute(String input) {
        List<String> words=List.of(input.split(" "));
        Long userId=Long.valueOf(words.get(0));
        SettleUpUserRequestDto requestDto=new SettleUpUserRequestDto();
        requestDto.setUserId(userId);

        SettleupResponseDto responseDto=settleupController.settleUpuser(requestDto);
    }

    @Override
    public boolean matches(String input) {
        List<String> words=List.of(input.split(" "));
        return words.size()==2 && words.get(1).equals(CommandKeywords.SettleUp);
    }
}
