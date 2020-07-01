package test_task

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.data.mongodb.config.EnableMongoAuditing

@Slf4j
@EnableMongoAuditing
@SpringBootApplication(exclude = [SecurityAutoConfiguration.class])
class Application {

    static void main(String[] args) {
        SpringApplication.run Application, args

        log.info("\n\n-----------------------------------------------------------------\n\n" +
                "\t\t*********************************************************\n" +
                "\t\t**********!!!! SERVER STARTED SUCCESSFULLY !!!!**********\n" +
                "\t\t*********************************************************\n" +
                "\n-----------------------------------------------------------------\n\n")
    }
}
