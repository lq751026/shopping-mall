package com.lq.gulimall.member.fegin;

import io.renren.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/*
*    这是一个声明式的远程调用
* */
@FeignClient("gulimall-coupn")//写调用服务的服务名
public interface CouponFeignSerivce {
    @GetMapping("/coupn/smscoupon/member/list")  //写访问其他服务上的字路径
    public R membercounpone();
}
