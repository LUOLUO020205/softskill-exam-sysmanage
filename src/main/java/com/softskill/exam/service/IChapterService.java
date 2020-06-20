package com.softskill.exam.service;

import com.softskill.exam.domain.Chapter;

import java.util.List;
import java.util.Map;

public interface IChapterService {
    /**
     * 根据课程ID获取所有的章节
     * @param params
     * @return
     */
    public List<Chapter> queryAllChapter(Map<String, Object> params);

    /**
     * 保存章节
     * @param chapter
     * @return
     */
    public int saveOrUpdate(Chapter chapter);

    /**
     * 删除章节
     * @param cChId 章节ID
     * @return
     */
    int deleteChapterBycChId(Long cChId);

    /**
     * 获取章节对象
     * @param cChId
     * @return
     */
    Chapter selectChapterById(Long cChId);
}
