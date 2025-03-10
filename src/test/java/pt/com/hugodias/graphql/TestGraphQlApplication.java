package pt.com.hugodias.graphql;

import org.springframework.boot.SpringApplication;

public class TestGraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.from(GraphQlApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
