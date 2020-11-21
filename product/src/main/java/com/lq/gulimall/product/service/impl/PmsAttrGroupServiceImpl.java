package com.lq.gulimall.product.service.impl;

import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import com.lq.gulimall.product.dao.PmsAttrGroupDao;
import com.lq.gulimall.product.entity.PmsAttrGroupEntity;
import com.lq.gulimall.product.service.PmsAttrGroupService;


@Service("pmsAttrGroupService")
public class PmsAttrGroupServiceImpl extends ServiceImpl<PmsAttrGroupDao, PmsAttrGroupEntity> implements PmsAttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsAttrGroupEntity> page = this.page(
                new Query<PmsAttrGroupEntity>().getPage(params),
                new QueryWrapper<PmsAttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
         if(catelogId==0){
             IPage<PmsAttrGroupEntity> page = this.page(new Query<PmsAttrGroupEntity>().getPage(params),
                     new QueryWrapper<PmsAttrGroupEntity>());
             return new PageUtils(page);
         }else{
             String key = (String) params.get("key");
             QueryWrapper<PmsAttrGroupEntity> wrapper=new QueryWrapper<PmsAttrGroupEntity>().eq("catelog_id",catelogId);
             if(!StringUtils.isNullOrEmpty(key)){
               wrapper.and((obj)->{
                  obj.eq("attr_group_id",key).or().like("attr_group_name",key);
               });
             }IPage<PmsAttrGroupEntity> page=this.page(new Query<PmsAttrGroupEntity>().getPage(params),
                     wrapper);
             return new PageUtils(page);
         }
    }

}