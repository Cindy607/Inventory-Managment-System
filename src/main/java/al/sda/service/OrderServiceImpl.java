package al.sda.service;

import al.sda.Dto.OrderDto;
import al.sda.Dto.OrderItemsDto;
import al.sda.Entity.Order;
import al.sda.Entity.OrderItems;
import al.sda.Entity.Product;
import al.sda.configure.HibernateConfig;
import al.sda.converter.OrderConverter;
import al.sda.dao.OrderDao;
import al.sda.dao.OrderDaoImpl;
import al.sda.dao.ProductDao;
import al.sda.dao.ProductDaoImpl;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    private ProductDao productDao = new ProductDaoImpl(sessionFactory);
    private OrderDao orderDao = new OrderDaoImpl(sessionFactory);

    @Override
    public Order create(OrderDto orderDto) {

        List<Long> productIds = orderDto.getOrderItemsDtoList()
                .stream()
                .map(orderItemDto -> orderItemDto.getProductId())
                .collect(Collectors.toList());


        List<Product> products = productDao.findAllById(productIds);

        HashMap<Long,Double> productPrices = new HashMap<>();
        for (Product product : products) {
            productPrices.put(product.getId(), product.getPrice());
        }

        Order order = OrderConverter.convertOrderToEntity(orderDto);

        order.getOrderItemsList().stream().forEach(orderItems -> orderItems.setPrice(productPrices.get(orderItems.getProduct().getId())));

        Double total = 0D;

        for (OrderItems orderItems:  order.getOrderItemsList()) {
            total+= orderItems.getPrice() * orderItems.getQuantity();
        }

        order.setTotal(total);
        orderDao.create(order);

        return null;

    }
}


