//
//package controllers;
//
//import java.util.List;
//import java.util.Map;
//
//import models.Article;
//import ninja.Result;
//import ninja.Results;
//
//import com.google.common.collect.Maps;
//import com.google.inject.Inject;
//
//import dao.ArticleDao;
//import dao.SetupDao;
//
//public class ApplicationController {
//
//    @Inject
//    ArticleDao articleDao;
//
//    @Inject
//    SetupDao setupDao;
//
//    public ApplicationController() {
//
//    }
//
//    /**
//     * Method to put initial data in the db...
//     * 
//     * @return
//     */
//    public Result setup() {
//
//        setupDao.setup();
//
//        return Results.ok();
//
//    }
//
//    public Result index() {
//
//        Article frontPost = articleDao.getFirstArticleForFrontPage();
//
//        List<Article> olderPosts = articleDao.getOlderArticlesForFrontPage();
//
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("frontArticle", frontPost);
//        map.put("olderArticles", olderPosts);
//
//        return Results.html().render("frontArticle", frontPost)
//                .render("olderArticles", olderPosts);
//
//    }
//}
