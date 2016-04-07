package com.nm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nm.model.AreaCode;
import com.nm.model.Children;
import com.nm.model.ChildrenBean;
import com.nm.model.SysRegionalBelong;
import com.nm.service.SysRegionalBelongService;
import com.nm.utils.GroupUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2016/4/6.
 */
@Controller
@RequestMapping("/sysRegionalBelong")
public class SysRegionalBelongController {
    @Resource
    private SysRegionalBelongService sysRegionalBelongService;

    @RequestMapping("/export")
    public void export(HttpServletResponse response) {
        List<SysRegionalBelong> sysRegionalBelongs = sysRegionalBelongService.getList();
        Map<String, List<SysRegionalBelong>> group = GroupUtil.group(sysRegionalBelongs, new GroupUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                SysRegionalBelong sysMsgPush = (SysRegionalBelong) obj;
                return sysMsgPush.getProvNo();
            }
        });
        List<AreaCode> list = new ArrayList<AreaCode>();
        for (Map.Entry<String, List<SysRegionalBelong>> stringListEntry : group.entrySet()) {
            AreaCode areaCode = new AreaCode();
            areaCode.setCode(stringListEntry.getKey());
            List<SysRegionalBelong> value = stringListEntry.getValue();
            areaCode.setName(value.get(0).getProvName());
            List<ChildrenBean> chcildrenBean = new ArrayList<ChildrenBean>();
            for (SysRegionalBelong sysRegionalBelong : value) {
                if (StringUtils.isEmpty(sysRegionalBelong.getAreaNo()) && StringUtils.isNotBlank(sysRegionalBelong.getCityNo())) {
                    ChildrenBean ch = new ChildrenBean();
                    ch.setCode(sysRegionalBelong.getCityNo());
                    ch.setName(sysRegionalBelong.getCityName());
                    ch.setpCode(areaCode.getCode());
                    List<Children> chList = new ArrayList<Children>();
                    for (SysRegionalBelong regionalBelong : value) {
                        if (StringUtils.equals(ch.getCode(), regionalBelong.getCityNo()) && StringUtils.isNotBlank(regionalBelong.getAreaNo())) {
                            Children c = new Children();
                            c.setCode(regionalBelong.getAreaNo());
                            c.setName(regionalBelong.getAreaName());
                            c.setpCode(ch.getCode());
                            chList.add(c);
                        }
                    }
                    ch.setChildren(chList);
                    chcildrenBean.add(ch);
                }
            }
            areaCode.setChildren(chcildrenBean);
            list.add(areaCode);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        BufferedOutputStream buff = null;
        ServletOutputStream outSTr = null;
        try {
            response.setContentType("application/octet-stream");
            String fileName = null;
            fileName = URLEncoder.encode("areaCode", "UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".json");
            StringBuffer write = new StringBuffer();
            outSTr = response.getOutputStream();
            buff = new BufferedOutputStream(outSTr);
            write.append(objectMapper.writeValueAsString(list));
            buff.write(write.toString().getBytes("UTF-8"));
            buff.flush();
            buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                buff.close();
                outSTr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
