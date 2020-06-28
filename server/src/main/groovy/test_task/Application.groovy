package test_task

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration

@Slf4j
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
