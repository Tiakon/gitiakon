package cn.tiakon.gitiakon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 * @author tiakon
 */
@RestController
@SpringBootApplication
public class GitiakonAppBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(GitiakonAppBootstrap.class, args);
    }
}
