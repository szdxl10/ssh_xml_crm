package com.wangzhanxiong.crm.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.wangzhanxiong.crm.domain.User;
import com.wangzhanxiong.crm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
/**
 * 用户管理的Action的类
 * @author Wangzhanxiong
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
    // 模型驱动使用的对象
    private User user = new User();
    @Override
    public User getModel() {
        return user;
    }

    // 注入Service:
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册的方法:regist
     */
    public String regist(){
        userService.regist(user);
        return LOGIN;
    }

    /**
     * 用户登录的方法：login
     */
    public String login(){
        // 调用业务层查询用户:
        User existUser = userService.login(user);
        if(existUser == null){
            // 登录失败
            // 添加错误信息:
            this.addActionError("用户名或密码错误!");
            return LOGIN;
        }else{
            // 登录成功
//			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
            ActionContext.getContext().getSession().put("existUser", existUser);
            return SUCCESS;
        }
    }

    public String findAllUser() throws IOException{
        List<User> list = userService.findAll();
        JSONArray jsonArray = JSONArray.fromObject(list);
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
        return NONE;
    }
}
