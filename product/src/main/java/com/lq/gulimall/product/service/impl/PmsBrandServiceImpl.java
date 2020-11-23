package com.lq.gulimall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.lq.gulimall.product.service.PmsCategoryBrandRelationService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import com.lq.gulimall.product.dao.PmsBrandDao;
import com.lq.gulimall.product.entity.PmsBrandEntity;
import com.lq.gulimall.product.service.PmsBrandService;


@Service("pmsBrandService")
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandDao, PmsBrandEntity> implements PmsBrandService {
   @Autowired
    PmsCategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
          //获取key的值
         QueryWrapper<PmsBrandEntity> queryWrapper=new QueryWrapper<>();
        String key = (String) params.get("key");
        if(!StringUtils.isNullOrEmpty(key)){
            queryWrapper.eq("brand_id",key).or().like("name",key);
        }
        IPage<PmsBrandEntity> page = this.page(
                new Query<PmsBrandEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void updateDetail(PmsBrandEntity pmsBrand) {
        //保证 数据的一致性
        this.updateById(pmsBrand);
        if(!StringUtils.isNullOrEmpty(pmsBrand.getName())){
             //同步更新其他关系链表中的数据
            categoryBrandRelationService.updateBrand(pmsBrand.getBrandId(),pmsBrand.getName());

            //TODO
        }
    }

}