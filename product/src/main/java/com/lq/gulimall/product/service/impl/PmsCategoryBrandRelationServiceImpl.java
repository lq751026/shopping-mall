package com.lq.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.UpdateChainWrapper;
import com.lq.gulimall.product.dao.PmsBrandDao;
import com.lq.gulimall.product.dao.PmsCategoryDao;
import com.lq.gulimall.product.entity.PmsBrandEntity;
import com.lq.gulimall.product.entity.PmsCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import com.lq.gulimall.product.dao.PmsCategoryBrandRelationDao;
import com.lq.gulimall.product.entity.PmsCategoryBrandRelationEntity;
import com.lq.gulimall.product.service.PmsCategoryBrandRelationService;


@Service("pmsCategoryBrandRelationService")
public class PmsCategoryBrandRelationServiceImpl extends ServiceImpl<PmsCategoryBrandRelationDao, PmsCategoryBrandRelationEntity> implements PmsCategoryBrandRelationService {
    @Autowired
    PmsBrandDao brandDao;
    @Autowired
    PmsCategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsCategoryBrandRelationEntity> page = this.page(
                new Query<PmsCategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<PmsCategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveDetail(PmsCategoryBrandRelationEntity pmsCategoryBrandRelation) {
        Long brandId = pmsCategoryBrandRelation.getBrandId();
        Long catelogId = pmsCategoryBrandRelation.getCatelogId();
        PmsBrandEntity brandEntity = brandDao.selectById(brandId);
        PmsCategoryEntity categoryEntity = categoryDao.selectById(catelogId);

        pmsCategoryBrandRelation.setBrandName(brandEntity.getName());
        pmsCategoryBrandRelation.setCatelogName(categoryEntity.getName());
      this.save(pmsCategoryBrandRelation);
    }

    @Override
    public void updateBrand(Long brandId, String name) {
        PmsCategoryBrandRelationEntity entity = new PmsCategoryBrandRelationEntity();
        entity.setBrandId(brandId);
        entity.setBrandName(name);
        this.update(entity,new UpdateWrapper<PmsCategoryBrandRelationEntity>().eq("brand_id",brandId));


    }

    @Override
    public void updateCategory(Long catId, String name) {
        this.baseMapper.updateCategory(catId,name);
    }

}