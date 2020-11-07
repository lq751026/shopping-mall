package com.lq.gulimall.coupn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lq.common.utils.PageUtils;
import com.lq.gulimall.coupn.entity.SeckillPromotionEntity;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author Mir 李
 * @email 1578442339@qq.com
 * @date 2020-11-07 16:02:26
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

