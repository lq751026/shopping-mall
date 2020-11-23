package com.lq.gulimall.product.service.impl;

import com.lq.gulimall.product.entity.PmsAttrGroupEntity;
import com.lq.gulimall.product.service.PmsCategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import com.lq.gulimall.product.dao.PmsCategoryDao;
import com.lq.gulimall.product.entity.PmsCategoryEntity;
import com.lq.gulimall.product.service.PmsCategoryService;


@Service("pmsCategoryService")
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryDao, PmsCategoryEntity> implements PmsCategoryService {
      @Autowired
      private PmsCategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsCategoryEntity> page = this.page(
                new Query<PmsCategoryEntity>().getPage(params),
                new QueryWrapper<PmsCategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<PmsCategoryEntity> listWithThree() {
          //1.查出所有分类
        List<PmsCategoryEntity> list = baseMapper.selectList(null);
        //组成父子结构
        //找出一级分类
        List<PmsCategoryEntity> collect = list.stream().filter((pmsCategoryEntity -> {
            return pmsCategoryEntity.getParentCid() == 0;
        })).map(menu->{
            menu.setChildren(getChider(menu,list));
            return menu;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

        return collect;
    }

    @Override
    public void removerMeunByIds(List<Long> asList) {
        //ToDo

        //逻辑删除
        baseMapper.deleteBatchIds(asList);
    }

    //递归查找所有菜单的子菜单
    private List<PmsCategoryEntity> getChider(PmsCategoryEntity root,List<PmsCategoryEntity> all){
        List<PmsCategoryEntity> collect = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == root.getCatId();
        }).map(categoryEntity -> {
            //1.找到子菜单
            categoryEntity.setChildren(getChider(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            //菜单的排序
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return collect;
    }
    //找到catelogId的完整路径
    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths=new ArrayList<>();
        List<Long> longs = findParentPath(catelogId, paths);
        Collections.reverse(longs);
        return longs.toArray(new Long[longs.size()]);
    }


    private List<Long> findParentPath(Long cateId,List<Long> paths){
        //收集当前节点的id
        paths.add(cateId);
        PmsCategoryEntity byId = this.getById(cateId);
        if(byId.getParentCid()!=0){
            findParentPath(byId.getParentCid(),paths);
        }
        return paths;
    }


    /**
     *  级联更新
     * @param pmsCategory
     */
    @Override
    public void updatecade(PmsCategoryEntity pmsCategory) {
       categoryBrandRelationService.updateCategory(pmsCategory.getCatId(),pmsCategory.getName());
    }
}