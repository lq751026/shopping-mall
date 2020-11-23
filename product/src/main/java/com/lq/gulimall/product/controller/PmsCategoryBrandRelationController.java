package com.lq.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lq.gulimall.product.entity.PmsCategoryBrandRelationEntity;
import com.lq.gulimall.product.service.PmsCategoryBrandRelationService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 品牌分类关联
 *
 * @author lq
 * @email 
 * @date 2020-11-09 19:28:38
 */
@RestController
@RequestMapping("product/pmscategorybrandrelation")
public class PmsCategoryBrandRelationController {
    @Autowired
    private PmsCategoryBrandRelationService pmsCategoryBrandRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsCategoryBrandRelationService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    //@RequestMapping("/catelog/list")
     @GetMapping("/catelog/list")
    public R list(@RequestParam("brandId")Long brandId){
        List<PmsCategoryBrandRelationEntity> list = pmsCategoryBrandRelationService.list(
                new QueryWrapper<PmsCategoryBrandRelationEntity>().eq("brand_id", brandId));

        return R.ok().put("page", list);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		PmsCategoryBrandRelationEntity pmsCategoryBrandRelation = pmsCategoryBrandRelationService.getById(id);

        return R.ok().put("pmsCategoryBrandRelation", pmsCategoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsCategoryBrandRelationEntity pmsCategoryBrandRelation){
		pmsCategoryBrandRelationService.saveDetail(pmsCategoryBrandRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PmsCategoryBrandRelationEntity pmsCategoryBrandRelation){
		pmsCategoryBrandRelationService.updateById(pmsCategoryBrandRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		pmsCategoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
