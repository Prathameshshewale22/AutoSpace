package com.app.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.PaymentDto;
import com.app.pojos.Cart;
import com.app.pojos.CartItem;
import com.app.pojos.Payment;
import com.app.pojos.PaymentMode;
import com.app.pojos.PaymentStatus;
import com.app.pojos.ServiceBooking;
import com.app.pojos.Services;
import com.app.repository.PaymentRepository;
import com.app.repository.ServiceBookingRepository;
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private CartServiceImpl cartService;
	
	@Autowired
	private ServiceBooking_ServiceImpl sbService;
	
	@Autowired
	private ServiceCenterServiceImpl sCenter;
	
	@Autowired
	private VehicleServiceImpl vService;

	@Override
	public ServiceBooking doPayment(PaymentDto payment) {
		Cart cart=cartService.getCartById(payment.getCartId());
		if(payment.getCardExpireDate().isAfter(LocalDate.now())) {
		  Payment newPayment=new Payment(payment.getPaymentMode(),payment.getCardNumber(),payment.getUpiId(), payment.getAmt());
		  if(newPayment!=null) {
			  newPayment.setPaymentStatus(PaymentStatus.COMPLELTE);
			  newPayment.addCart(cartService.getCartById(payment.getCartId()));
			  Payment donePayment = paymentRepo.save(newPayment);
			  ServiceBooking addedBooking = processBooking(cart,payment.getPickupDropAddress(),donePayment,payment.getServiceCenterId(),payment.getVehicleId());
			  return  addedBooking;
		  }
	}
		//throw error
		return null;
	}

	@Override
	public ServiceBooking processBooking(Cart foundCart,String PickupDropaddress,Payment donePayment,Long ServiceCenterId,Long VehicleId) {
		ServiceBooking newServiceBooking=new ServiceBooking();
		newServiceBooking.addPayment(donePayment);
		newServiceBooking.addCustomer(foundCart.getCartOwner());
		newServiceBooking.addServiceCenter(sCenter.findCenterById(ServiceCenterId));
		newServiceBooking.addVehicle(vService.findVehicleById(VehicleId));
		newServiceBooking.setPickupDropAddress(PickupDropaddress);
		List<CartItem> allItems=foundCart.getCartItems();
		allItems.forEach(item->newServiceBooking.addService(item.getService()));
		 ServiceBooking NewBooking = sbService.addNewBooking(newServiceBooking) ;
		 cartService.clearCart(foundCart.getCartOwner().getId());
		 return NewBooking;
	}

}
