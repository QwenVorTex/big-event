package org.ccnuiot.bigevent.controller;

import org.ccnuiot.bigevent.pojo.Category;
import org.ccnuiot.bigevent.pojo.Result;
import org.ccnuiot.bigevent.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody @Validated Category category) {

        categoryService.add(category);
        return Result.success();
    }
}
