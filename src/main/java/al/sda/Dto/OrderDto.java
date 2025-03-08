package al.sda.Dto;

import al.sda.Entity.OrderItems;
import al.sda.Entity.PaymentStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private Long clientId;
    private PaymentStatusEnum paymentStatusEnum;

    List<OrderItemsDto> orderItemsDtoList = new ArrayList<>();

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public PaymentStatusEnum getPaymentStatusEnum() {
        return paymentStatusEnum;
    }

    public void setPaymentStatusEnum(PaymentStatusEnum paymentStatusEnum) {
        this.paymentStatusEnum = paymentStatusEnum;
    }

    public List<OrderItemsDto> getOrderItemsDtoList() {
        return orderItemsDtoList;
    }

    public void setOrderItemsDtoList(List<OrderItemsDto> orderItemsDtoList) {
        this.orderItemsDtoList = orderItemsDtoList;
    }
}
