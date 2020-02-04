package com.vnit.awp;

public class Distance {
	
	DistanceRec[] distRecArray= new DistanceRec[10];
	public int index=0;
			
	public Distance() {
		// TODO Auto-generated constructor stub
		distRecArray[0]= new DistanceRec("Airport", "VNIT", 6);
		distRecArray[1]= new DistanceRec("Airport", "RailwayStation", 8);
		distRecArray[2]= new DistanceRec("VNIT", "RailwayStation", 7);
		distRecArray[3]= new DistanceRec("VNIT", "BusStand", 5);
		distRecArray[4]= new DistanceRec("BusStand", "RailwayStation", 9);
		distRecArray[5]= new DistanceRec("BusStand", "Airport", 10);
		
		index=5;

	}
	
	public int getDistance(String _startPoint, String _endPoint) {
		int i=0;
		int returnVal=0;
		
		while(i<=index && returnVal==0) {
			
			if(
				(_startPoint.equals(distRecArray[i].startPoint) && _endPoint.equals(distRecArray[i].endPoint))
				|| 
				(_startPoint.equals(distRecArray[i].endPoint) && _endPoint.equals(distRecArray[i].startPoint))
			) {
				returnVal= distRecArray[i].distance;
				//System.out.println("Return Value individual " + returnVal); DEBUGGING PURPOSES
			}
			i++;
				
		}
		return returnVal;
	}
	
	public int getDistance(String[] _pointsArray){
		int returnVal = 0;
	    int i=1;
	    int temp=0;
	        
	    	
	        while( i < _pointsArray.length && _pointsArray[i]!=null){
	        	temp=0;
		        temp= getDistance( _pointsArray[i-1], _pointsArray[i]);
		        
	            returnVal = returnVal + temp;
	            //System.out.println("Return second val " + returnVal); DEBUGGING PURPOSES
	            //getDistance( _pointsArray[i-1], _pointsArray[i]);
	            i++;
	        }

	        return returnVal;
	}

}
