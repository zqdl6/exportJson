package com.nm.utils;

import java.util.*;

/**
 * Created by lenovo on 2016/3/4.
 */
public class GroupUtil {
    public interface GroupBy<T> {
        T groupby(Object obj) ;
    }
    public static final <T extends Comparable<T> ,D> Map<T ,List<D>> group(Collection<D> colls ,GroupBy<T> gb){
        if(colls == null || colls.isEmpty()) {
            System.out.println("分组集合不能为空");
            return null ;
        }
        if(gb == null) {
            System.out.println("分组依据接口不能为空");
            return null ;
        }
        Iterator<D> iter = colls.iterator() ;
        Map<T ,List<D>> map = new HashMap<T, List<D>>() ;
        while(iter.hasNext()) {
            D d = iter.next() ;
            T t = gb.groupby(d) ;
            if(map.containsKey(t)) {
                map.get(t).add(d) ;
            } else {
                List<D> list = new ArrayList<D>() ;
                list.add(d) ;
                map.put(t, list) ;
            }
        }
        return map ;
    }
}
