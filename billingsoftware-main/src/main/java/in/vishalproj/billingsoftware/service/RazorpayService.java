package in.vishalproj.billingsoftware.service;

import com.razorpay.RazorpayException;

import in.vishalproj.billingsoftware.io.RazorpayOrderResponse;

public interface RazorpayService {

   RazorpayOrderResponse createOrder(Double amount, String currency) throws RazorpayException;
} 
