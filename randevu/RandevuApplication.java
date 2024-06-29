package learn.randevu;

import jakarta.annotation.PostConstruct;
import learn.randevu.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling

@SpringBootApplication
public class RandevuApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandevuApplication.class, args);
	}
}
