package com.atlauncher.acc;

import java.io.Serializable;

public final class Account implements Comparable<Account>, Cloneable, Serializable{
	private static final long serialVersionUID = -7495549305510416500L;
	
	private final String name;
	
	public Account(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Account){
			return ((Account) obj).name.equals(this.name);
		} else if(obj instanceof String){
			return ((String) obj).equals(this.name);
		} else{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode();
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
	public static Account getFiller(){
		return new Account("Select an Account");
	}

	@Override
	public int compareTo(Account acc){
		return acc.name.compareTo(this.name);
	}
}