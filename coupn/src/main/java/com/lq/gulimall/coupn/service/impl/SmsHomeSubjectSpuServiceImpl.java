package com.lq.gulimall.coupn.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import com.lq.gulimall.coupn.dao.SmsHomeSubjectSpuDao;
import com.lq.gulimall.coupn.entity.SmsHomeSubjectSpuEntity;
import com.lq.gulimall.coupn.service.SmsHomeSubjectSpuService;


@Service("smsHomeSubjectSpuService")
public class SmsHomeSubjectSpuServiceImpl extends ServiceImpl<SmsHomeSubjectSpuDao, SmsHomeSubjectSpuEntity> implements SmsHomeSubjectSpuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsHomeSubjectSpuEntity> page = this.page(
                new Query<SmsHomeSubjectSpuEntity>().getPage(params),
                new QueryWrapper<SmsHomeSubjectSpuEntity>()
        );

        return new PageUtils(page);
    }

}