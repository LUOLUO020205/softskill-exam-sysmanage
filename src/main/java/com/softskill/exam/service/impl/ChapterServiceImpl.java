package com.softskill.exam.service.impl;

import com.softskill.exam.dao.ChapterMapper;
import com.softskill.exam.domain.Chapter;
import com.softskill.exam.domain.PageModel;
import com.softskill.exam.service.IChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class ChapterServiceImpl implements IChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public List<Chapter> queryAllChapter(Map<String, Object> params) {
        PageModel pageModel=(PageModel) params.get("pageModel");
        Long count = chapterMapper.countAllChapterByCouseId(params);
        pageModel.setRecordCount(count);
        return chapterMapper.selectAllChapterByCouseId(params);
    }

    @Override
    public int saveOrUpdate(Chapter chapter) {
        if(StringUtils.isEmpty(chapter.getcChId())){
            return chapterMapper.insert(chapter);
        }else{
            return chapterMapper.updateByPrimaryKey(chapter);
        }
    }

    @Override
    public int deleteChapterBycChId(Long cChId) {
        return chapterMapper.deleteByPrimaryKey(cChId);
    }

    @Override
    public Chapter selectChapterById(Long cChId) {
        return chapterMapper.selectByPrimaryKey(cChId);
    }


}
