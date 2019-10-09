package com.tourism.conteoller;

import com.tourism.entity.Article;
import com.tourism.service.IArticleService;
import com.tourism.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 未判断当前用户是否登陆,权限未设置,
 * @author
 * @date
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private IArticleService iArticleService;


    @RequestMapping(value = "/art",method =RequestMethod.GET)
    public String art(){
        return "article";
    }

    @RequestMapping(value = "/add",method =RequestMethod.GET)
    public String add(){
        return "addArticle";
    }

    @RequestMapping(value = "/update",method =RequestMethod.GET)
    public String update(){
        return "updateArticle";
    }



    @RequestMapping(value = "/article_list_content")
    public String article_list_content(){
        return "article_list_content";
    }

    /**
     * 用户旅行资讯 文章总数 user/article_list_content
     * @return
     */
    @RequestMapping(value = "/articleNum",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult articleNum(){
        int articleNum = iArticleService.articleNum();
        return new JsonResult(articleNum);
    }

    /**
     * 用户网站 文章展示 user/article
     * @return
     */
    @RequestMapping("/articleAll")
    @ResponseBody
    public JsonResult articleAll(){
        List<Article> articles = iArticleService.articleAll();
        return new JsonResult(articles);
    }

    /**
     * 管理员首页 文章数据及其数量 admin/index
     * @return
     */
    @RequestMapping(value = "/unPageList",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult unPageList(){
        List<Article> unPageList = null;
        unPageList = iArticleService.selectUnPage();
        return new JsonResult(unPageList);
    }

    /**
     * 用户网站 根据文章id查询数据 user/article_list_content
     * @param articleId
     * @return
     */
    @RequestMapping(value="/articleById",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectById(Integer articleId){
        Article article = iArticleService.selectById(articleId);
        return new JsonResult(article);
    }

    /**
     * 根据id删除对应文章 common/article
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteArticle",method = RequestMethod.GET)
    public String deleteArticle(int id){
        iArticleService.deleteByPrimaryKey(id);
        return "article";
    }

    /**
     * 文章的增加    common/addArticle
     * @param article
     * @return
     * No converter found for return value of type: class java.lang.Integer
     * 未找到类型为java.lang.Integer的返回值的转换器
     * int 返回数据 习惯性错误
     */
    @RequestMapping(value = "/addArticle",method= RequestMethod.GET)
    @ResponseBody
    public JsonResult insertArticle(Article article){
        iArticleService.insert(article);
        return new JsonResult("OK");
    }

    /**
     * 查询文章总数   common/article
     * @return
     */
    /*@RequestMapping(value = "/selectPage",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectPage(){
        Integer page=iArticleService.selectPage();
        return new JsonResult(page);
    }*/

    /**
     * 分页查询展示数据 common/article
     * @param pageStart
     * @param pageEnd
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult articleList(int pageStart, int pageEnd){
            List<Article> articleList = null;
            articleList = iArticleService.selectByList(pageStart,pageEnd);
            return new JsonResult(articleList);
    }



    /**
     * 修改页面   修改文章信息,ajax提交数据到后台进行修改  common/updateArticle
     * "OK" == 200  HTTP状态码 已建立连接  state
     * @param article
     * @return
     */
    @RequestMapping(value = "/updateArticle", method=RequestMethod.GET)
    @ResponseBody
    public JsonResult updateArticle(Article article){
        iArticleService.updateByPrimaryKey(article);
        return new JsonResult("OK");
    }
}
