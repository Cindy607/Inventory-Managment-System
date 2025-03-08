package al.sda.service;

import al.sda.Dto.OrderDto;
import al.sda.Dto.OrderItemsDto;
import al.sda.Entity.Order;

public interface OrderService {

     Order create(OrderDto orderDto);

}
