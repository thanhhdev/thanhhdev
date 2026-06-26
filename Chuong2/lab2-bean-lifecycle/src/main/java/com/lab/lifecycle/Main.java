package com.lab.lifecycle;

import com.lab.lifecycle.config.AppConfig;
import com.lab.lifecycle.managed.ManagedBean;
import com.lab.lifecycle.prototype.RequestProcessor;
import com.lab.lifecycle.singleton.ServiceA;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // All singletons are eager: their constructors + @PostConstruct run
        // here, during context startup. Watch the order in the log below:
        // ServiceB is created before ServiceA because ServiceA depends on it.
        System.out.println("--- Before context ---");
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("--- After context ---\n");

        // Demo 1 -- dependency-graph init order (see startup log above)
        System.out.println("=== Demo 1: Thu tu khoi tao Bean ===");
        ctx.getBean(ServiceA.class).doWork();

        // Demo 2 -- managed bean lifecycle hooks
        System.out.println("\n=== Demo 2: Vong doi ManagedBean ===");
        ctx.getBean(ManagedBean.class).doWork();

        // Demo 3 -- singleton vs prototype identity
        System.out.println("\n=== Demo 3: Singleton ===");
        var a1 = ctx.getBean(ServiceA.class);
        var a2 = ctx.getBean(ServiceA.class);
        System.out.println("a1 == a2 ? " + (a1 == a2)); // -> true

        System.out.println("\n=== Demo 3: Prototype ===");
        var p1 = ctx.getBean(RequestProcessor.class);
        var p2 = ctx.getBean(RequestProcessor.class);
        var p3 = ctx.getBean(RequestProcessor.class);
        p1.process("Request A");
        p2.process("Request B");
        p3.process("Request C");
        System.out.println("p1 == p2 ? " + (p1 == p2)); // -> false
        System.out.println("p1 == p3 ? " + (p1 == p3)); // -> false

        // @PreDestroy fires here, before the bean is destroyed
        System.out.println("\n--- Dong context (ctx.close()) ---");
        ctx.close();
    }
}
