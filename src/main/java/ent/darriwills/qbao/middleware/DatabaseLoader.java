package ent.darriwills.qbao.middleware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductsRepository repository) {
        return args -> {
            log.info("Pre-loading...\t" + repository.save(new Products(
                    "Product Brand ABC",
                    "Hello world!",
                    "''",
                    "2025-1-1"
            )));

        }
    }
}