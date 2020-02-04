package com.vnit.awp;
import java.util.*;
import java.util.Random;

public class Customer {
	int custUsername;
	String custName;
	int custPhone;
	String custEmail;
	String custPassword;
	
	//Random r;
	//long s=24;
	
	public Customer(int _custUsername, String _custName, int _custPhone, String _custEmail, String _custPassword) {
		// TODO Auto-generated constructor stub
		//r = new Random();
		//r.setSeed(s);
		custUsername =  _custUsername;
		custName= _custName;
		custPhone=_custPhone;
		custEmail = _custEmail;
		custPassword =_custPassword;
	}
	
	public int getCustUsername() {
		return custUsername;
	}

}
