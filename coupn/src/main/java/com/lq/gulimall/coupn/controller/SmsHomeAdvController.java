package com.lq.gulimall.coupn.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lq.gulimall.coupn.entity.SmsHomeAdvEntity;
import com.lq.gulimall.coupn.service.SmsHomeAdvService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 首页轮播广告
 *
 * @author lq
 * @email 
 * @date 2020-11-09 19:29:45
 */
@RestController
@RequestMapping("coupn/smshomeadv")
public class SmsHomeAdvController {
    @Autowired
    private SmsHomeAdvService smsHomeAdvService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsHomeAdvService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SmsHomeAdvEntity smsHomeAdv = smsHomeAdvService.getById(id);

        return R.ok().put("smsHomeAdv", smsHomeAdv);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SmsHomeAdvEntity smsHomeAdv){
		smsHomeAdvService.save(smsHomeAdv);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SmsHomeAdvEntity smsHomeAdv){
		smsHomeAdvService.updateById(smsHomeAdv);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		smsHomeAdvService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
