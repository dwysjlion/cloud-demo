package cn.itcast.order.service;


import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import com.dwysj.feign.cilents.UserClient;
import com.dwysj.feign.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClient userClient;
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        //根据用户id，查询出用户信息
//        Long userId = order.getUserId();
//
//        User user = restTemplate.getForObject("http://userserver/user/" + userId, User.class);
//        order.setUser(user);
//
//        // 4.返回
//        return order;
//    }

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //根据用户id，查询出用户信息
        Long userId = order.getUserId();

        User user = userClient.queryById(userId);
        order.setUser(user);
        System.out.println("333333");
        System.out.println("hot by mf");
        System.out.println("hot test");

        // 4.返回
        return order;
    }


}
