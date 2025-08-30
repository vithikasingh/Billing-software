package in.vishalproj.billingsoftware.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import in.vishalproj.billingsoftware.io.RazorpayOrderResponse;
import in.vishalproj.billingsoftware.service.RazorpayService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RazorpayServiceImpl implements RazorpayService{

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;
    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    @Override
    public RazorpayOrderResponse createOrder(Double amount, String currency) throws RazorpayException {
       RazorpayClient razorpayClient = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
       JSONObject orderRequest=new JSONObject();
         orderRequest.put("amount", amount * 100); // Convert to paise
            orderRequest.put("currency", currency);
            orderRequest.put("receipt","order_rcptid"+ System.currentTimeMillis());
            orderRequest.put("payment_capture", 1); // Auto capture payment

            Order order = razorpayClient.orders.create(orderRequest);
            return ConvertToResponse(order);

    }

    private RazorpayOrderResponse ConvertToResponse(Order order) {
        return RazorpayOrderResponse.builder()
                .id(order.get("id"))
                .entity(order.get("entity"))
                .amount(order.get("amount"))
                .currency(order.get("currency"))
                .status(order.get("status"))
                .created_At(order.get("created_at"))
                .receipt(order.get("receipt"))
                .build();

    }
    
}
