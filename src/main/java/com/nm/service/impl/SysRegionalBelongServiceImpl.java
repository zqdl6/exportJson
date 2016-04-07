package com.nm.service.impl;

import com.nm.mapper.SysRegionalBelongMapper;
import com.nm.model.SysRegionalBelong;
import com.nm.service.SysRegionalBelongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2016/4/6.
 */
@Service
public class SysRegionalBelongServiceImpl implements SysRegionalBelongService {
    @Resource
    private SysRegionalBelongMapper sysRegionalBelongMapper;
    public List<SysRegionalBelong> getList(){
        return sysRegionalBelongMapper.selectAll();
    }
}
