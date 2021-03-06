package com.lq.gulimall.product.dao;

import com.lq.gulimall.product.entity.PmsCategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 品牌分类关联
 * 
 * @author lq
 * @email 
 * @date 2020-11-09 19:28:38
 */
@Mapper
public interface PmsCategoryBrandRelationDao extends BaseMapper<PmsCategoryBrandRelationEntity> {

    void updateCategory(@Param("catId") Long catId,@Param("name") String name);
}
