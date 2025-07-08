package org.ccnuiot.bigevent.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.ccnuiot.bigevent.pojo.Article;
import org.ccnuiot.bigevent.pojo.Result;
import org.ccnuiot.bigevent.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }
}
