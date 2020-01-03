package com.hwx.blog.service;

import com.hwx.blog.entity.Notice;

import java.util.List;

public interface INoticeService {

    List<Notice> getNoticeList();

    Notice selectOne(Integer id);

    void update(Notice notice);

    void deleteOne(Integer id);

    void addOne(Notice notice);
}
