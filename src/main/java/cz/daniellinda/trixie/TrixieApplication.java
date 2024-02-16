package cz.daniellinda.trixie;

import cz.daniellinda.trixie.client.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrixieApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrixieApplication.class, args);
        Service.start();
    }

}
