package com.tourism.service;

import com.tourism.entity.Article;

import java.util.List;

public interface IArticleService {


    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectById(Integer articleId);

    int articleNum();

    List<Article> selectByList(int pageStart, int pageEnd);

    List<Article> selectUnPage();

    List<Article> articleAll();

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

}
