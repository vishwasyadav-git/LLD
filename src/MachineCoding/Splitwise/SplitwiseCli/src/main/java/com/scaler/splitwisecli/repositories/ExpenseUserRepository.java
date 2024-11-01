package com.scaler.splitwisecli.repositories;

import com.scaler.splitwisecli.models.ExpenseUser;
import com.scaler.splitwisecli.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser,Long> {

    List<ExpenseUser> findByUser(User user);

}
