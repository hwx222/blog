package com.hwx.blog.service.impl;

import com.hwx.blog.entity.Notice;
import com.hwx.blog.mapper.NoticeMapper;
import com.hwx.blog.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNoticeList() {
        return noticeMapper.getNoticeList();
    }

    @Override
    public Notice selectOne(Integer id) {
        return noticeMapper.selectById(id);
    }

    @Override
    public void update(Notice notice) {
        noticeMapper.updateById(notice);
    }

    @Override
    public void deleteOne(Integer id) {
        noticeMapper.deleteById(id);
    }

    @Override
    public void addOne(Notice notice) {
        noticeMapper.insertOne(notice);
    }
}
