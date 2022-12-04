package dev.eeren;

import dev.eeren.utility.common.util.DomainComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})})
public class AccountInfraApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountInfraApplication.class, args);
    }
}