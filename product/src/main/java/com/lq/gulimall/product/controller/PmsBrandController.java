package com.lq.gulimall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.lq.gulimall.product.vaild.AddGroup;
import com.lq.gulimall.product.vaild.UpdataStatus;
import com.lq.gulimall.product.vaild.UpdateGroup;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lq.gulimall.product.entity.PmsBrandEntity;
import com.lq.gulimall.product.service.PmsBrandService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author lq
 * @email 
 * @date 2020-11-09 19:28:38
 */
@RestController
@RequestMapping("product/pmsbrand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsBrandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId){
		PmsBrandEntity pmsBrand = pmsBrandService.getById(brandId);

        return R.ok().put("pmsBrand", pmsBrand);
    }

    /**
     * 保存
     * @Valid 开启校验
     */
    @RequestMapping("/save")
    public R save(@Validated(value = {AddGroup.class}) @RequestBody PmsBrandEntity pmsBrand){
     /*   BindingResult result
        if(result.hasErrors()){
             Map<String,String> map=new HashMap<>();
             //获取校验的错误结果
            result.getFieldErrors().forEach((item)->{
                 //获取到的错误提示
                String message=item.getDefaultMessage();
                String fied=item.getField();
                map.put(fied,message);
            });
            return R.error(400,"提交的数据不合法").put("data",map);
        }else{

        }*/
        pmsBrandService.save(pmsBrand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@Validated(value = {UpdateGroup.class}) @RequestBody PmsBrandEntity pmsBrand){
		pmsBrandService.updateDetail(pmsBrand);

        return R.ok();
    }


    /**
     * 修改状态
     */
    @RequestMapping("/update/sataus")
    public R updateSataus(@Validated(value = {UpdataStatus.class}) @RequestBody PmsBrandEntity pmsBrand){
        pmsBrandService.updateById(pmsBrand);
        return R.ok();
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds){
		pmsBrandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
