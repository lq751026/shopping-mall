package com.lq.gulimall.order.dao;

import com.lq.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author lq
 * @email 
 * @date 2020-11-09 19:57:10
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
