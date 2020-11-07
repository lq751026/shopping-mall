package com.lq.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lq.common.utils.PageUtils;
import com.lq.gulimall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * Ʒ�Ʒ������
 *
 * @author Mir 李
 * @email 1578442339@qq.com
 * @date 2020-11-06 22:39:31
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

