package com.lq.gulimall.coupn.dao;

import com.lq.gulimall.coupn.entity.CouponSpuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author Mir 李
 * @email 1578442339@qq.com
 * @date 2020-11-07 16:02:26
 */
@Mapper
public interface CouponSpuRelationDao extends BaseMapper<CouponSpuRelationEntity> {
	
}
