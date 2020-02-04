package com.vnit.awp;
import com.vnit.awp.CarType;

public class CarDesc extends CarType {
	String carName;
    String carModel;
    String carNumber;
    float pricePerKm;
    int carAvailable;

    public CarDesc(String _carType,String _carName, String _carModel, String _carNumber, float _pricePerKm, int _carAvailable) {
    	carType = _carType;
        carName = _carName;
        carModel = _carModel;
        carNumber = _carNumber;
        pricePerKm = _pricePerKm;
        carAvailable = _carAvailable;
    }
    

}
