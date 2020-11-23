package com.lq.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lq.gulimall.product.entity.PmsCategoryEntity;
import com.lq.gulimall.product.service.PmsCategoryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 商品三级分类
 *
 * @author lq
 * @email 
 * @date 2020-11-09 19:28:38
 */
@RestController
@RequestMapping("product/pmscategory")
public class PmsCategoryController {
    @Autowired
    private PmsCategoryService pmsCategoryService;

    /**
     *查出所有分类以及分类 以树形结构组装起来
     */
    @RequestMapping("/list/tree")
    public R list(){
       List<PmsCategoryEntity> list= pmsCategoryService.listWithThree();
        return R.ok().put("data", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
		PmsCategoryEntity pmsCategory = pmsCategoryService.getById(catId);

        return R.ok().put("data", pmsCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsCategoryEntity pmsCategory){
		pmsCategoryService.save(pmsCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PmsCategoryEntity pmsCategory){
        pmsCategoryService.updateById(pmsCategory);
		pmsCategoryService.updatecade(pmsCategory);

        return R.ok();
    }

    /**
     * 批量修改
     */
    @RequestMapping("/update/sort")
    public R updateSprt(@RequestBody PmsCategoryEntity[] pmsCategory){
        pmsCategoryService.updateBatchById(Arrays.asList(pmsCategory));
        return R.ok();
    }


    /**
     * 删除
     * @RequestBody  获取请求体   必须发送post请求体
     * spring Mvc 自动将
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
		pmsCategoryService.removeByIds(Arrays.asList(catIds));
		pmsCategoryService.removerMeunByIds(Arrays.asList(catIds));
        return R.ok().put("msg","成功");
    }

}
