package com.lq.gulimall.coupn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lq.common.utils.PageUtils;
import com.lq.gulimall.coupn.entity.CouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author Mir 李
 * @email 1578442339@qq.com
 * @date 2020-11-07 16:02:26
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

