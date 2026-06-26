package com.lab.lifecycle.managed;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ManagedBean {

    public ManagedBean() {
        System.out.println("  [1] Constructor: object duoc tao");
    }

    @PostConstruct
    public void init() {
        // Runs AFTER constructor + DI completes.
        // Use for: init cache, open DB connection, validate config...
        System.out.println("  [2] @PostConstruct: bean san sang");
    }

    public void doWork() {
        System.out.println("  [*] doWork() duoc goi");
    }

    @PreDestroy
    public void cleanup() {
        // Runs BEFORE the bean is destroyed (context.close()).
        // Use for: close connection, flush buffer, release resources...
        System.out.println("  [3] @PreDestroy: don dep truoc khi huy");
    }
}
