package in.vishalproj.billingsoftware.controller;

import java.time.LocalDate;

import java.util.List;
import in.vishalproj.billingsoftware.io.OrderResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.vishalproj.billingsoftware.io.DashboardResponse;
import in.vishalproj.billingsoftware.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final OrderService orderService;

    @GetMapping
    public DashboardResponse getDashboardData(){
        LocalDate today = LocalDate.now();
        Double todaySales = orderService.sumSalesByDate(today);
        Long todayOrderCount = orderService.countByOrdersDate(today);
        List<OrderResponse> recentOrders =orderService.findRecentOrders();
        return new DashboardResponse(
            todaySales !=null ? todaySales : 0.0,
            todayOrderCount != null ? todayOrderCount : 0,
            recentOrders
        );

    }

    
    
}
