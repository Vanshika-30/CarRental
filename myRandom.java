package com.vnit.awp;
import java.util.*;
import java.lang.Math; 


public class myRandom {
	
	Random r;
	
	public myRandom() {
		// TODO Auto-generated constructor stub
		r = new Random();
		r.setSeed(24);
	}
	
	public int getMyRandom() {
		return Math.abs(r.nextInt()/10000);
	}

}
