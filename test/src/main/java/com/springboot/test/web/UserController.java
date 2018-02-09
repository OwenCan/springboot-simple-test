package com.springboot.test.web;

import com.springboot.test.domain.User;
import com.springboot.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Owen Zhao
 * @Description:
 * @Date: Created in 2018/2/6 15:05
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 展示用户列表
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createUserForm(ModelMap map){
        map.addAttribute("user",new User());
        map.addAttribute("action","create");
        return "userForm";
    }

    /**
     * 创建用户表单
     *
     * @param user 传递的参数
     *             通过modelattribute来传递参数
     * @return
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        userService.insertByUser(user);
        return "redirect:/users/list";
    }

    /**
     * 获取用户列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String getUserList(ModelMap map){
        map.addAttribute("userList",userService.findAll());
        return "userList";
    }

    /**
     * 进入更新User信息页面
     * @param id @PathVariable 用来绑定参数
     *           get请求 通过id 寻找User
     *           {id} id 通过绑定的参数进行查找
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String updateUserForm(@PathVariable Long id,ModelMap map){
        map.addAttribute("user",userService.findById(id));
        map.addAttribute("action","update");
        return "userForm";
    }

    /**
     * 用户列表更新，
     * @param user 前台通过表单传递过来
     * @param map
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateUser(@ModelAttribute User user, ModelMap map){
        userService.update(user);
        return "redirect:/users/list";
    }

    /**
     * 展示删除用户列表
     * @param id 用户Id
     *           @PathViriable 是用来从路径获取参数值
     *           @RequestParam 从request域中拿值
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteUserForm(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users/list";
    }
}
