package org.shops.controllers;

import java.util.List;

import org.shops.dao.AccountRepository;
import org.shops.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AccountController {
	@Autowired
	AccountRepository accountRepository;
	
	//This method to save an account
	@RequestMapping(value="/Account", method=RequestMethod.POST)
	public Account saveAccount(@RequestBody Account account){
		return this.accountRepository.save(account);
	}
	
	//This method to search an account
	@RequestMapping(value="/FindAccount", method=RequestMethod.POST)
	public boolean findAccount(@RequestBody Account account){
		boolean b=true;
		List<Account> l=this.accountRepository.findAll();
		for(int i=0;i<l.size();i++){
			if((l.get(i).getEmail().equals(account.getEmail()))
					&&(l.get(i).getPassword().equals(account.getPassword())))
			{
				b=true;
				break;
			}
			else{
				b=false;
			}
		}
		return b;
	}
	
	//This method to check the existence of an account
	@RequestMapping(value="/FindByEmail", method=RequestMethod.POST)
	public boolean findByEmail(@RequestBody Account account){
		boolean b=true;
		List<Account> l=this.accountRepository.findAll();
		for(int i=0;i<l.size();i++){
			if((l.get(i).getEmail().equals(account.getEmail())))
			{
				b=true;
				break;
			}
			else{
				b=false;
			}
		}
		return b;
	}
	
	
}
