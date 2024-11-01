package com.scaler.splitwisecli;

import com.scaler.splitwisecli.commands.CommandExecutor;
import com.scaler.splitwisecli.commands.SettleUpUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseCliApplication {
	@Autowired
	private static CommandExecutor commandExecutor;
	public static void main(String[] args) {

		SpringApplication.run(SplitwiseCliApplication.class, args);
		//CommandExecutor commandExecutor=new CommandExecutor();
		//commandExecutor.addCommand(new SettleUpUserCommand());

		Scanner scanner=new Scanner(System.in);

		while (true) {
			String input= scanner.next();
			commandExecutor.execute(input);
		}
	}

}
