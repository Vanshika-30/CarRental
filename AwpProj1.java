
package com.vnit.awp;
import java.util.*;
import com.vnit.awp.*;

public class AwpProj1 {
	public static void main(String[] args) {
		
		myRandom mr = new myRandom(); 
		Distance dc= new Distance();
		Scanner s = new Scanner(System.in);
		Customer[] custArray = new Customer[20];
		
		String custName;
		int custPhone;
		String custEmail;
		String custPassword;
		int i = 3, j;
		int flag = 0, chances = 0;
		int login = 0;
		String customerName; 
		int userIndex = 0, carIndex = 0;
		
		//HARDCODED DRIVER VALUES
		Driver[] driverDetails = new Driver[6];
		driverDetails[0] = new Driver("Prince", 935668742, "MH02-20160043", "Xcent");
		driverDetails[1] = new Driver("Chinmay", 948463722, "MH06-20760065", "Dezire");
		driverDetails[2] = new Driver("Fadia", 786549336, "MH08-20140234", "Eon");
		driverDetails[3] = new Driver("Warun", 847839290, "MH42-20130862", "Datsun Go");
		driverDetails[4] = new Driver("Umang", 746739894, "MH02-20160043", "Wagnor");
		driverDetails[5] = new Driver("Shraddha", 967859483, "MH03-20170013", "Innova Crysta");
		
		//HARDCODED CAR DETAILS
		CarDesc[] car = new CarDesc[6];
		car[0] = new CarDesc("Mini", "Wagnor", "LXi", "MH02-1123", 6.0f,1);
		car[1] = new CarDesc("Mini", "Dezire", "LXi", "MH06-7895", 6.0f,1);
		car[2] = new CarDesc("Micro", "Eon", "LXi", "MH08-0127", 15.0f,1);
		car[3] = new CarDesc("Micro", "Datsun GO", "LXi", "MH42-9823", 15.0f,1);
		car[4] = new CarDesc("Prime", "Innova Crysta", "LXi", "MH43-8965", 24.0f,1);
		car[5] = new CarDesc("Prime", "Xcent", "LXi", "MH03-7623", 24.0f,1);
		
		//HARDCODED INITIAL CUSTOMER VALUES
		custArray[0] = new Customer(mr.getMyRandom(), "Vanshika", 934567819, "vanshika@gmail.com", "vanshika123");
		custArray[1]= new Customer(mr.getMyRandom(), "Rishika", 934607891, "rishika@gmail.com", "rishika123");
		custArray[2]= new Customer(mr.getMyRandom(), "Amit", 890765421, "amit@gmail.com", "amit123");
		
		//	TEST LOGIN CASE	
		System.out.println("test login case " + custArray[1].custUsername);
		
		System.out.println();
		System.out.println("Welcome to VR Car Rentals");
		
		//REGISTRATION AND LOGIN
		while(login == 0) {
			System.out.println("Do you wish to Login(0) or Register(1)");
			int input = s.nextInt();
			switch (input) {
			case 0:						//LOGIN
				while(flag == 0 && chances <3) {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter Username : ");
					int usernameInput = sc.nextInt();
					System.out.println("Enter Password : ");
					String PasswordMatch = sc.next();
					int match = 0;
					for(j=0; j<i; j++) {
						if(usernameInput == custArray[j].custUsername && match == 0 ) {
							if(PasswordMatch.equals(custArray[j].custPassword) == true) {
								System.out.println("Access Granted!");
								match = 1;
								flag = 1;
								userIndex = j;								
							}
							else {
								System.out.println("Wrong password");
							}
						}
					}
					if(j == i && match == 0) {
						System.out.println("Wrong username and password, try again");
					}
					chances++;
				} 
				login = 1;
				break;

			case 1:					//REGISTRATION
				//custName= s.nextLine();
				//System.out.print("Enter your Name: \n");
				
				custName = s.nextLine();
				do {
					System.out.println("Enter Name");
					custName= s.nextLine();
				}while(custName.isEmpty());
//				while(nameFlag==0 && custName.isEmpty()) {
//					System.out.println("CustName length " + custName.length());
//					if(custName.length()==0 || custName==null || custName.isEmpty()) {
//						System.out.println("Enter a valid name");
//						custName= s.next();
//					}
//					else {
//						System.out.println("Entered else");
//						nameFlag=1;
//					}
//				}
//				
				System.out.print("Enter your Phone no.: \n");
				custPhone = s.nextInt();
				
				System.out.print("Enter your E-mail: \n ");
				custEmail = s.next();
				
				System.out.print("Enter your Password: \n ");
				custPassword = s.next();
				
				custArray[i] = new Customer(mr.getMyRandom(),custName, custPhone,custEmail,custPassword );
				i++;
				for(int k =0; k<i; k++) { 					//ALL USER IDS
					System.out.println(custArray[k].custUsername);
				}											//LAST USER ID IS THE NEW USER'S ID
				System.out.println();
				break;

			}
		}
		
		//SELECTING PATHS. VIAS TAKEN INTO CONSIDERATION
		System.out.println("How many locations would you like to visit?");
		int via= s.nextInt();
		String[] basicPoints= {"Airport", "BusStand", "VNIT", "RailwayStation"};
		
		System.out.println("All possible combinations for the following routes are possible. Please check spellings carefully. ");
		
		for(int l=0; l<4; l++) {
			System.out.println(basicPoints[l] + " ");
		}
		
		String[] custLocations = new String[8];
		
		System.out.println("Enter your locations ");
	
		for(int m=0; m<via; m++) {
			custLocations[m]= s.next();
		}
		
		int totalDistance = dc.getDistance(custLocations);		//TOTAL DISTANCE

		//TYPE OF CARS AVAILABLE
		customerName = custArray[userIndex].custName;
		System.out.println("Types of cars availabe:");
		System.out.println("1.Mini	2.Micro	3.Prime");
		String typeOfCar = s.next();
		
			int t, select = 1;
			int notBook=0, b=2;
			String confirmBooking;
		while(b!=0 && notBook==0) {
			while(select == 1) {				//CAR AVAILABILITY
				for(t=0; t<6; t++) {
					if(typeOfCar.equals(car[t].carType)) {
						if(car[t].carAvailable == 1) {
							System.out.println(t + " " + car[t].carName + " Rs." + car[t].pricePerKm);
							select = 0;
							
						}
					}
				}
					int tryIndex, carInt;
				if(select == 0) {				//CAR SELECTION
												
					try{						//EXCEPTION HANDLING
						
						System.out.println("Select car index of car you wish to use " + customerName);
						tryIndex = s.nextInt();
						carInt=	car[tryIndex].carAvailable;
						}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Please select car index within range. Start Again. Exiting booking module " + customerName);
						return;
						}
					
					float totalPrice= car[carIndex].pricePerKm * (float)totalDistance;
					System.out.println("total distance " + totalDistance);
					System.out.println("Total price is Rs." + totalPrice);
				}
				if(t == 6 && select == 1) {
					System.out.println("No cars of this type available" + customerName);
				}
			}
			
			System.out.println("Do you confirm your booking? y or n ");
			confirmBooking= s.next();
			if(confirmBooking.equals("y")) {
				notBook=1;
				
				for(int z = 0; z<6; z++) { 			//PRINT DRIVER DETAILS
					if(driverDetails[z].carAssigned.contentEquals(car[carIndex].carName)) {
						System.out.println(driverDetails[z].carAssigned + " " + driverDetails[z].name+ " "
								+ driverDetails[z].mobileNo);
					}
				}
				System.out.println("All required details have been sent to you on " + custArray[userIndex].custEmail);
			}
			else {
				System.out.println("Try again");
			}
			b--;
		}
		
		if(notBook==0) {
			System.out.println("Thank you for viewing our website " + custArray[userIndex].custName);
		}
		else {
			System.out.println("Thank you for booking from our website " + custArray[userIndex].custName);
			System.out.println(car[carIndex].carName + " is booked for " +  custArray[userIndex].custUsername );


		}


	} 

}

