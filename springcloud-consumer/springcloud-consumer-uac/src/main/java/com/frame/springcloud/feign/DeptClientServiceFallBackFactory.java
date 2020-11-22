package com.frame.springcloud.feign;


import com.frame.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//Hystrix的失败回调接口工厂
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {

    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {

            public List<Dept> queryAll() {
                return null;
            }

        };
    }
}
