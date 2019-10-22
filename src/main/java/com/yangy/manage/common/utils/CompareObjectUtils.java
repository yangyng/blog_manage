package com.yangy.manage.common.utils;

import com.yangy.manage.domain.SysMenu;
import com.yangy.manage.domain.SysUser;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 用于获取两个对象之间不同的值对应的列
 *
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年08月22日 14:45
 **/
public class CompareObjectUtils {

//    public static void main(String[] args) throws Exception {
//        SysUser sysUser = new SysUser();
//        sysUser.setEmail("email");
//        sysUser.setNickName("nickname");
//
//        SysUser sysUser1 = new SysUser();
//        sysUser1.setEmail("email");
//        sysUser1.setNickName("nickname1");
//
//        SysMenu sysMenu = new SysMenu();
//        sysMenu.setDesp("");
//        LinkedList<Map<String, Object>> mapLinkedList = compareAndGet(new String(), new String());
//        for (Map<String, Object> map : mapLinkedList) {
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                System.out.println(entry.getKey() + ": " + entry.getValue());
//            }
//            System.out.println("=====");
//        }
//    }

    /**
     * 比较两个相同类型对象中值不同 的字段
     * <p>
     *      param o1
     *          name 1 age 2 sex 1
     *      param o2
     *          name 2 age 2 sex 1
     *      return name
     * </p>
     * @param o1
     * @param o2
     * @param excludeFields
     * @return java.util.LinkedList<java.util.Map < java.lang.String, java.lang.Object>>
     * @date 2019-08-22
     * @author yang yang
     **/
    private static LinkedList<Map<String, Object>> compareAndGet(Object o1, Object o2, String... excludeFields) throws Exception {
        String[] fields = excludeFields;
        Class<?> o1Class = o1.getClass();
        //判断 对象的泛型是否一致
        if (!o1Class.isInstance(o2)) {
            throw new RuntimeException("请传入一致的对象类型");
        }

        //获取该实体类的所有方法
        Method[] methods = o1Class.getDeclaredMethods();
        LinkedList<Map<String, Object>> nameList = new LinkedList<>();
        for (Method method : methods) {
            //该方法是否为 get() 或者 is()
            boolean IsGetMethod = method.getName().startsWith("get") || method.getName().startsWith("is");
            if (IsGetMethod && 0 == method.getParameterCount()) {
                String name = method.getName();
                if (name.startsWith("get")) {
                    name = name.replace("get", "");
                } else if (name.startsWith("is")) {
                    name = name.replace("is", "");
                }

                name = name.replaceFirst(String.valueOf(name.charAt(0)), String.valueOf(name.charAt(0)).toLowerCase());
                Object invoke1 = method.invoke(o1, null);
                Object invoke2 = method.invoke(o2, null);
                //至少有一个非空的值
                boolean oneNotEmpty = (null == invoke1 && null != invoke2) || (null != invoke1 && null == invoke2);
                if (oneNotEmpty) {
                    HashMap<String, Object> map = new LinkedHashMap<>(3);
                    map.put("fieldName", name);
                    map.put("o1Value", invoke1);
                    map.put("o2Value", invoke2);
                    nameList.add(map);
                }
                //o1 和 o2 存在 对应的 field 值不同
                if (null != invoke1 && null != invoke2 && !invoke1.equals(invoke2)) {
                    Map<String, Object> map = new LinkedHashMap<>(3);
                    map.put("fieldName", name);
                    map.put("o1Value", invoke1);
                    map.put("o2Value", invoke2);
                    nameList.add(map);
                }
            }
        }
        return nameList;
    }
}
