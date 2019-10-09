package com.tourism.conteoller;

import com.tourism.service.IUserService;
import com.tourism.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    /**
     * 管理员首页 用户数量 admin/index
     * @return
     */
    @RequestMapping("/userNum")
    @ResponseBody
    public JsonResult userNum(){
       int usn = iUserService.userNum();
        return new JsonResult(usn);
    }
}
