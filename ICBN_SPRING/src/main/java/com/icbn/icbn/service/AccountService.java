package com.icbn.icbn.service;

import java.security.Principal;

import com.icbn.icbn.domain.PrimaryAccount;
import com.icbn.icbn.domain.SavingsAccount;

public interface AccountService {
	
    PrimaryAccount createPrimaryAccount();
    
    SavingsAccount createSavingsAccount();
    
    void deposit(String accountType, double amount, Principal principal);
    
    void withdraw(String accountType, double amount, Principal principal);
    
}
