package com.atlauncher.acc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class Accounts{
    private static Accounts instance;

    private Accounts(){}

    public static Accounts getInstance(){
        return instance == null ? instance = new Accounts() : instance;
    }

    private final List<Account> accounts = new LinkedList<>();

    public Account getAccount(String name){
        for(Account acc : this.accounts){
            if(acc.getName().equals(name)){
                return acc;
            }
        }

        return null;
    }

    public void addAccount(Account acc){
        if(this.getAccount(acc.getName()) != null){
            return;
        }

        this.accounts.add(acc);
    }

    public List<Account> getAccounts(){
        return Collections.unmodifiableList(this.accounts);
    }
}