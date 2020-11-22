package com.frame.springcloud.feign;


import com.frame.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//fegin的负载均衡接口
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-UAC",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

    @RequestMapping("/dept/list")
    public List<Dept> queryAll();

}
