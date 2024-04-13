package cn.itcast.order.web;

import cn.itcast.order.config.PatternProperties;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("order")
//@RefreshScope
public class OrderController {

   @Autowired
   private OrderService orderService;
   @Autowired
   private PatternProperties patternProperties;
//   @Value("${pattern.dateformat}")
//   private String dateformat;



    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId, @RequestHeader(value = "mf",required = false)String mf) {
        // 根据id查询订单并返回
        System.out.println("mf:=====>"+mf);
        return orderService.queryOrderById(orderId);
    }

    @GetMapping("/now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()))+"============="+ patternProperties.getDateformat();
    }

}
