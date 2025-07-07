package org.ccnuiot.bigevent.service;

import org.ccnuiot.bigevent.pojo.Category;

import java.util.List;

public interface CategoryService {

    void add(Category category);

    List<Category> list();
}
