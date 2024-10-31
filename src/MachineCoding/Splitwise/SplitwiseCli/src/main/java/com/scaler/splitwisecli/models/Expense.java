package com.scaler.splitwisecli.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity(name = "expenses")
@Getter
@Setter
public class Expense extends BaseModel{
    private String description;
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
    @ManyToOne
    private  Group group;
    @OneToMany(mappedBy = "expense")
    private List<ExpenseUser> expenseUsers;

}
