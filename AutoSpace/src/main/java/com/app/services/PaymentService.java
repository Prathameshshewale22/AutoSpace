package com.app.services;

import com.app.dto.PaymentDto;
import com.app.pojos.Cart;
import com.app.pojos.Payment;
import com.app.pojos.ServiceBooking;

public interface PaymentService {
	
	ServiceBooking doPayment(PaymentDto payment);
	
	ServiceBooking processBooking(Cart foundCart,String PickupDropaddress,Payment donePayment,
			                       Long ServiceCenterId,Long vehicleId);

}
