package org.shops;
import org.shops.dao.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebCodingChallengeShopsApplication implements CommandLineRunner{
	@Autowired
	ShopRepository shopRepository;
	public static void main(String[] args) {
		SpringApplication.run(WebCodingChallengeShopsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
	}
}
