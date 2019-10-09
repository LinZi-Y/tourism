package com.tourism.conteoller;

import com.tourism.entity.User;
import com.tourism.service.IOrderService;
import com.tourism.service.IUserService;
import com.tourism.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author
 * @date
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private IOrderService iOrderService;

    /**
     * 管理员首页 订单数量 admin/index
     * @return
     */
    @RequestMapping("/orderNum")
    @ResponseBody
    public JsonResult orderNum(){
        int osn = iOrderService.quireOrderNum();
        return new JsonResult(osn);
    }

}
