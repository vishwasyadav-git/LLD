package com.scaler.splitwisecli.services;

import com.scaler.splitwisecli.exceptions.UserNotFoundexception;
import com.scaler.splitwisecli.models.Expense;
import com.scaler.splitwisecli.models.ExpenseUser;
import com.scaler.splitwisecli.models.User;
import com.scaler.splitwisecli.repositories.ExpenseUserRepository;
import com.scaler.splitwisecli.repositories.UserRepository;
import com.scaler.splitwisecli.strategy.SettleUpStrategy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;
    public SettleUpService(UserRepository userRepository,ExpenseUserRepository expenseUserRepository,SettleUpStrategy settleUpStrategy){
        this.userRepository=userRepository;
        this.expenseUserRepository=expenseUserRepository;
        this.settleUpStrategy=settleUpStrategy;
    }
    public List<Expense> settleUpUser(Long userId) throws UserNotFoundexception {
        /*
        1. Get the user from given userId from DB
        2.Get all the expenses in which this user is involved
        3.Iterate through all the expenses and find out who has paid extra/lesser
        for every user involved in the above list of expenses.
        4. Use mInHeap and MaxHeap to find out list of transaction required to settle up the user
         */
        Optional<User>  optionalUser=userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new UserNotFoundexception("User with Id "+userId+" not found");
        }
        User user= optionalUser.get();

        List<ExpenseUser> expenseUsers=expenseUserRepository.findByUser(user);

        Set<Expense> expenses=new HashSet<>();
        for(ExpenseUser expenseUser:expenseUsers){
            expenses.add(expenseUser.getExpense());
        }
        //convert set to list
        List<Expense> expenseListToSettleIp=expenses.stream().toList();

        //Heap algo to settle up list of expenses
        List<Expense> finalExpenses=settleUpStrategy.settleUp(expenseListToSettleIp);

        return finalExpenses;
    }
    public List<Expense> settleUpGroup(Long groupId){
        /*
        1. Get the group from given groupID from DB
        2.Get all the expenses within this group
        3.Iterate through all the expenses and find out who has paid extra/lesser
        for every user involved in the above list of expenses.
        4. Use mInHeap and MaxHeap to find out list of transaction required to settle up the user
         */

        return null;
    }

}
