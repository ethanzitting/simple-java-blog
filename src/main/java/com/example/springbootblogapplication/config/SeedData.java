package com.example.springbootblogapplication.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springbootblogapplication.models.Account;
import com.example.springbootblogapplication.models.Post;
import com.example.springbootblogapplication.services.AccountService;
import com.example.springbootblogapplication.services.PostService;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0) {
            Account account1 = new Account();
            Account account2 = new Account();

            account1.setFirstName("user");
            account1.setLastName("user");
            account1.setEmail("user.user@domain.com");
            // account1.setPassword("password");

            account2.setFirstName("admin");
            account2.setLastName("admin");
            account2.setEmail("admin.admin@domain.com");
            // account1.setPassword("password");

            accountService.save(account1);
            accountService.save(account2);

            Post post1 = new Post();
            post1.setTitle("new title");
            post1.setBody("new body");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("new title");
            post2.setBody("new body");
            post2.setAccount(account2);

            postService.save(post1);
            postService.save(post2);
        }
    }
}
