package com.example.springbootneo4j;


import com.example.springbootneo4j.account.Account;
import com.example.springbootneo4j.account.AccountRepository;
import com.example.springbootneo4j.account.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {

    @Autowired
    Neo4jTemplate neo4jTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Account account = new Account();
        account.setUsername("pm430_repo");
        account.setEmail("open.js@gmail.com_repo");

        Role role = new Role();
//        role.setUsername("admin");
        role.setUsername("user");

        account.getRoles().add(role);

//        neo4jTemplate.save(account);
        accountRepository.save(account);

        System.out.println("finished");
    }
}
