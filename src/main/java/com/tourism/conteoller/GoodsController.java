package com.tourism.conteoller;

import com.tourism.entity.Goods;
import com.tourism.service.IGoodsService;
import com.tourism.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *
 *
 * @author k
 * @date
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private IGoodsService iGoodsService;


    /**
     * 已登录情况下,点击购买(传入用户id和商品id),跳转到order页面
     * @return
     */
    @RequestMapping("/showGoods")
    public String showGoods(){
        return "order";
    }

    /**
     * 根据商品id查询商品信息并展示 common/order
     * @param gId
     * @return
     */
    @RequestMapping("/selectById")
    @ResponseBody
    public JsonResult selectById(Integer gId){
        Goods goods = iGoodsService.selectByPrimaryKey(gId);
        return new JsonResult(goods);
    }

    /**
     * 管理员首页 商品数量 admin/index
     * @return
     */
    @RequestMapping(value = "/orderNum",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult orderNum(){
        int gsn = iGoodsService.goodsNum();
        return new JsonResult(gsn);
    }
}
