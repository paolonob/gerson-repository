package find;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pnm.dataLayer.entities.Film;
import com.pnm.dataLayer.repositories.CategoryRepository;
import com.pnm.dataLayer.repositories.FilmRepository;
import com.pnm.dataLayer.repositories.LanguageRepository;
import com.pnm.logicLayer.components.services.FilmManager;

@SpringBootApplication
@ComponentScan(basePackages = {"com.pnm.logicLayer.components", "find"})
@EntityScan("com.pnm.dataLayer.entities")
@EnableJpaRepositories("com.pnm.dataLayer")
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
