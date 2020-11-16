package com.lq.gulimall.coupn.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.lq.gulimall.coupn.entity.SmsCouponEntity;
import com.lq.gulimall.coupn.service.SmsCouponService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 优惠券信息
 *
 * @author lq
 * @email 
 * @date 2020-11-09 19:29:45
 */
@RestController
@RefreshScope  //动态刷新nacos的配置文件
@RequestMapping("coupn/smscoupon")
public class SmsCouponController {
    @Autowired
    private SmsCouponService smsCouponService;

    @Value("${lq.user.name}")
    private  String name;

    @Value("${lq.user.age}")
    private String age;

    @RequestMapping("/test")
    public R test(){
         return new R().ok().put("name",name).put("age",age);
    }

    @GetMapping("member/list")
    public R membercounpone(){
        SmsCouponEntity couponEntity=new SmsCouponEntity();
        couponEntity.setCouponName("满100剪10");
        return R.ok().put("counpon",Arrays.asList(couponEntity));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsCouponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SmsCouponEntity smsCoupon = smsCouponService.getById(id);

        return R.ok().put("smsCoupon", smsCoupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SmsCouponEntity smsCoupon){
		smsCouponService.save(smsCoupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SmsCouponEntity smsCoupon){
		smsCouponService.updateById(smsCoupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		smsCouponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
