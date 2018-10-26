package com.example.springchallenge;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    AccountRepository repository;

    @Override
    public void run(String... strings)throws Exception{
        Account account = new Account("12345","500");
        repository.save(account);

         account = new Account("567890","1000");
        repository.save(account);


         account = new Account("98765","5000");
        repository.save(account);
    }



}
