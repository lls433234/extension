package com.jiuyao.boot.controller;

import com.jiuyao.boot.entity.Page;
import com.jiuyao.boot.entity.PublicUser;
import com.jiuyao.boot.entity.Salesman;
import com.jiuyao.boot.entity.User;
import com.jiuyao.boot.entity.dto.Message;
import com.jiuyao.boot.entity.dto.MessageEnum;
import com.jiuyao.boot.service.PublicUserService;
import com.jiuyao.boot.service.SalesmanService;
import com.jiuyao.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class BackController {

    @Autowired
    private UserService userService;
    @Autowired
    private SalesmanService salesmanService;
    @Autowired
    private PublicUserService publicUserService;

    /**
     * 添加业务员
     *
     * @return
     */
    @RequestMapping("/addPublicUser")
    public String addSalesman() {
        return "publicUserRegister";
    }


    /**
     * 获取所有业务员绑定的用户
     *
     * @return
     */
    @RequestMapping("/getUserByPublicUser")
    public ModelAndView getUserByPublicUser(String page) {
        ModelAndView mv = new ModelAndView();
        System.out.println(page);
        Page<User> page2 = new Page<>();
        //查询所有业绩记录
        List<User> all = userService.getAll();
        int pageTotal = page2.setPageTotal(all.size());
        int ps = 1;
        if (page == null) {
            ps = page2.calculatePageSize(1);
        } else {
            ps = page2.calculatePageSize(new Integer(page));
        }
        int start = (ps - 1) * page2.getPageCount();
        int end = page2.getPageCount();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("end", end);
        List<User> allUserList = userService.getAllByLimit(map);
        for (User user : allUserList) {
            if (user != null) {
                String salesmanExtensionId = user.getSalesmanId();
                PublicUser oneByPublicUserExtensionId = publicUserService.getOneBySalesmanExtensionId(salesmanExtensionId);
                if (oneByPublicUserExtensionId != null) {
                    user.setSalesmanName(oneByPublicUserExtensionId.getName());
                } else {
                    user.setSalesmanName("未知");
                }
            }
        }
        mv.setViewName("userList");
        mv.addObject("allUserList", allUserList);
        mv.addObject("pageTotal", pageTotal);
        return mv;
    }


    /**
     * 业务员看个人信息
     *
     * @return
     */
    @RequestMapping("/querySalesman")
    public ModelAndView querySalesman(@RequestParam("salesmanExtensionId") String salesmanExtensionId) {
        System.out.println(salesmanExtensionId);
        Salesman oneBySalesmanExtensionId = salesmanService.getOneBySalesmanExtensionId(salesmanExtensionId);
        if (oneBySalesmanExtensionId != null) {
            String status = oneBySalesmanExtensionId.getStatus();
            String type = oneBySalesmanExtensionId.getType();
            if (status.equals("1")) {
                oneBySalesmanExtensionId.setStatus("审核中");
            } else if (status.equals("2")) {
                oneBySalesmanExtensionId.setStatus("审核通过");
            } else if (status.equals("3")) {
                oneBySalesmanExtensionId.setStatus("审核拒绝");
            }
            if (type.equals("1")) {
                oneBySalesmanExtensionId.setType("管理员");
            } else if (type.equals("2")) {
                oneBySalesmanExtensionId.setType("业务员");
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("querySalesman");
        mv.addObject("salesman", oneBySalesmanExtensionId);
        return mv;
    }


    /**
     * 业务员查看个人绑定的用户
     *
     * @param salesmanExtensionId 推广码
     * @return
     */
    @RequestMapping("/queryUser")
    public ModelAndView queryUser(@RequestParam("salesmanExtensionId") String salesmanExtensionId) {
        ModelAndView mv = new ModelAndView();
        List<User> usersBySalesman = userService.getAllBySalesmanExtensionId(salesmanExtensionId);
        for (User user : usersBySalesman) {
            String salesmanId = user.getSalesmanId();
            Salesman salesman = salesmanService.getOneBySalesmanExtensionId(salesmanId);
            if (salesman != null) {
                user.setSalesmanName(salesman.getName());
            } else {
                user.setSalesmanName("未知");
            }
        }
        mv.setViewName("salesmanUser");
        mv.addObject("usersBySalesman", usersBySalesman);
        return mv;
    }

}
