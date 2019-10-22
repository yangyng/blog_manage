//package com.yangy.manage.common.utils;
//
//import com.alibaba.fastjson.JSON;
//import com.yangkeai.blog.modules.sys.entity.SysMenu;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author yang yang
// * @email yangy_0329@163.com
// * @create 2019/1/4
// */
//public class Test {
//
//    public static void main(String[] args) {
//        List<SysMenu> data = getData();
//
//        List<Long> list = data.parallelStream()
//                .sorted(Comparator.comparing(SysMenu::getParentId))
//                .distinct()
//                .map(SysMenu::getParentId)
//                .collect(Collectors.toList());
//
//        Long aLong = list.get(0);
//        List<SysMenu> menuListA = data.stream().filter(menu -> menu.getParentId().equals(aLong)).collect(Collectors.toList());
//
//        for (SysMenu sysMenu : menuListA) {
//            sysMenu.setList(getChild(sysMenu.getMenuId(),data));
//        }
//
//
//        System.out.println(JSON.toJSONString(menuListA));
//        System.out.println(JSON.toJSONString(menuListA));
//    }
//
//    /**
//     * 递归查找子菜单
//     *
//     * @param id       当前菜单id
//     * @param rootMenu 要查找的列表
//     * @return
//     */
//    private static List<SysMenu> getChild(Long id, List<SysMenu> rootMenu) {
//        // 子菜单
//        List<SysMenu> childList = new ArrayList<>();
//        for (SysMenu menu : rootMenu) {
//            // 遍历所有节点，将父菜单id与传过来的id比较
//            if (null != menu.getParentId()) {
//                if (menu.getParentId().equals(id)) {
//                    childList.add(menu);
//                }
//            }
//        }
//        // 把子菜单的子菜单再循环一遍
//        for (SysMenu menu : childList) {// 没有url子菜单还有子菜单
//            if (StringUtils.isBlank(menu.getUrl())) {
//                // 递归
//                menu.setList(getChild(menu.getMenuId(), rootMenu));
//            }
//        } // 递归退出条件
//        if (childList.size() == 0) {
//            return null;
//        }
//        return childList;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    private static List<SysMenu> getData() {
//        SysMenu menu1 = SysMenu.builder().menuId(1L).parentId(0L).build();
//        SysMenu menu2 = SysMenu.builder().menuId(2L).parentId(0L).build();
//        SysMenu menu4 = SysMenu.builder().menuId(4L).parentId(1L).build();
//        SysMenu menu5 = SysMenu.builder().menuId(5L).parentId(1L).build();
//        SysMenu menu6 = SysMenu.builder().menuId(6L).parentId(2L).build();
//        SysMenu menu3 = SysMenu.builder().menuId(3L).parentId(0L).build();
//        SysMenu menu7 = SysMenu.builder().menuId(7L).parentId(3L).build();
//        SysMenu menu8 = SysMenu.builder().menuId(8L).parentId(4L).build();
//        SysMenu menu9 = SysMenu.builder().menuId(9L).parentId(5L).build();
//        SysMenu menu11 = SysMenu.builder().menuId(11L).parentId(7L).build();
//        SysMenu menu10 = SysMenu.builder().menuId(10L).parentId(6L).build();
//        SysMenu menu12 = SysMenu.builder().menuId(12L).parentId(8L).build();
//        SysMenu menu13 = SysMenu.builder().menuId(13L).parentId(9L).build();
//
//        List<SysMenu> linkedList = new ArrayList<>();
//        linkedList.add(menu2);
//        linkedList.add(menu3);
//        linkedList.add(menu1);
//        linkedList.add(menu5);
//        linkedList.add(menu9);
//        linkedList.add(menu10);
//        linkedList.add(menu6);
//        linkedList.add(menu4);
//        linkedList.add(menu11);
//        linkedList.add(menu7);
//        linkedList.add(menu12);
//        linkedList.add(menu8);
//        linkedList.add(menu13);
//        return linkedList;
//    }
//
//
//}
