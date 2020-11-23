package com.lq.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.lq.gulimall.product.service.PmsCategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lq.gulimall.product.entity.PmsAttrGroupEntity;
import com.lq.gulimall.product.service.PmsAttrGroupService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 属性分组
 *
 * @author lq
 * @email 
 * @date 2020-11-09 19:28:37
 */
@RestController
@RequestMapping("product/pmsattrgroup")
public class PmsAttrGroupController {
    @Autowired
    private PmsAttrGroupService pmsAttrGroupService;
    @Autowired
    private PmsCategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
    public R list(@RequestParam Map<String, Object> params,@PathVariable("catelogId")Long catelogId){
        //PageUtils page = pmsAttrGroupService.queryPage(params);
        PageUtils page=  pmsAttrGroupService.queryPage(params,catelogId);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		PmsAttrGroupEntity pmsAttrGroup = pmsAttrGroupService.getById(attrGroupId);
        Long catelogId = pmsAttrGroup.getCatelogId();
        Long [] path= categoryService.findCatelogPath(catelogId);
        pmsAttrGroup.setCatelogPath(path);
        return R.ok().put("pmsAttrGroup", pmsAttrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsAttrGroupEntity pmsAttrGroup){
		pmsAttrGroupService.save(pmsAttrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PmsAttrGroupEntity pmsAttrGroup){
		pmsAttrGroupService.updateById(pmsAttrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		pmsAttrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
