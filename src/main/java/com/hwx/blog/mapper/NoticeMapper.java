package com.hwx.blog.mapper;

import com.hwx.blog.entity.Notice;

import java.util.List;

public interface NoticeMapper {

    List<Notice> getNoticeList();

    Notice selectById(Integer id);

    void updateById(Notice notice);

    void deleteById(Integer id);

    void insertOne(Notice notice);
}
