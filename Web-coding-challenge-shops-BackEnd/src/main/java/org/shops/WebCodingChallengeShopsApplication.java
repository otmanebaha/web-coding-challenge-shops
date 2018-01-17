package org.shops;
import org.shops.dao.AccountRepository;
import org.shops.dao.ShopRepository;
import org.shops.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebCodingChallengeShopsApplication implements CommandLineRunner{
	@Autowired
	AccountRepository accountRepository;
	public static void main(String[] args) {
		SpringApplication.run(WebCodingChallengeShopsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
	//	this.accountRepository.save(new Account("baha@gmail.com", "baha"));
		//this.accountRepository.save(new Account("otm@gmail.com", "otm"));
	}
}
