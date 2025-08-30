package in.vishalproj.billingsoftware.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;

import in.vishalproj.billingsoftware.io.OrderRequest;
import in.vishalproj.billingsoftware.io.OrderResponse;
import in.vishalproj.billingsoftware.io.PaymentVerificationRequest;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);

    void deleteOrder(String orderId);

    List<OrderResponse> getLatestOrders();

    OrderResponse verifyPayment(PaymentVerificationRequest request);

    Double sumSalesByDate(LocalDate date);

    Long countByOrdersDate(LocalDate date);

    List<OrderResponse> findRecentOrders();
}
