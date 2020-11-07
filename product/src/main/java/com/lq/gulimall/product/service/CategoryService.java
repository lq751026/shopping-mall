package com.lq.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lq.common.utils.PageUtils;
import com.lq.gulimall.product.entity.CategoryEntity;

import java.util.Map;

/**
 * ��Ʒ��������
 *
 * @author Mir 李
 * @email 1578442339@qq.com
 * @date 2020-11-06 22:39:31
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

