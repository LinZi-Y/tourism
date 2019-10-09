package com.tourism.conteoller;

import com.alibaba.fastjson.JSONObject;
import com.tourism.entity.Admin;
import com.tourism.entity.User;
import com.tourism.service.IAdminService;
import com.tourism.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author
 * @date
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Resource
    private IAdminService iAdminService;
    @Resource
    private IUserService iUserService;


    @RequestMapping("/index")
    public String index(){
        return "admin/index";
    }
    @RequestMapping("/main")
    public String main(){
        return "admin/page/main";
    }
    /**
     * 登陆
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public String login( String username,String password){
        int byUP =iAdminService.findByUP(username,password);
        if (byUP > 0){
            return "1";
        }else {
            return "0";
        }
    }
//添加管理员
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public String register( String username, String nickname, String password){
        Admin admin = new Admin(username,nickname,password);
        int i = iAdminService.insertSelective(admin);
        if (i > 0){
            return "1";
        }else {
            return "0";
        }
    }
    //修改管理员密码
    @RequestMapping(value = "/updateKey",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public String updateKeyByName( String username, String oldPwd, String Password){
        int i=0;
        if (iAdminService.findByUP(username, oldPwd)!=0){
            //名字找id
            int id = iAdminService.idByName(username);
            Admin admin = new Admin(id, Password);
            i = iAdminService.updateByPrimaryKeySelective(admin);
        }
        if (i > 0){
            return "1";
        }else {
            return "0";
        }
    }

    //删除管理员
    @RequestMapping(value = "/deleteAdmin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public void deleteAdminById( int id){
        int i = iAdminService.deleteByPrimaryKey(id);
    }
    //批量删除管理员
    @RequestMapping(value = "/MuchDeleteAdmin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public void MuchDeleteAdmin(int[] a){
        int i1 =0;
        for (int i = 0; i <a.length ; i++) {
            i1 = iAdminService.deleteByPrimaryKey(a[i]);
        }
    }
    //删除用户
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public void deleteUserById( int id){
        iUserService.deleteByPrimaryKey(id);
    }
    //批量删除用户
    @RequestMapping(value = "/MuchDeleteUser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public void MuchDeleteUser(int[] a){
        int i1 =0;
        for (int i = 0; i <a.length ; i++) {
            i1 = iAdminService.deleteByPrimaryKey(a[i]);
        }
    }
    //添加用户
    @RequestMapping(value = "/addUser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public void addUser
    (String userName,String nickName,String password,String userEmail,String phone,String userSex,String describe){
        User user = new User(userName,nickName,password,userSex,userEmail,phone,describe);
        int i = iUserService.insertSelective(user);
    }
    //查看用户资料
    @RequestMapping(value = "/showUser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public String showUser(int id){
        User user = iUserService.selectByPrimaryKey(id);
        String s = JSONObject.toJSONString(user);
        if (user !=null){
            return s;
        }else {
            return null;
        }
    }


}
