package com.softskill.exam.vo;

import com.softskill.exam.domain.Question;

import java.util.List;

/**
 * 试题Vo
 */
public class QuestionVo extends Question{

    private List<String> cQoContents;

    private List<String> cQoIds;

    public void setcQoContents(List<String> cQoContents) {
        this.cQoContents = cQoContents;
    }

    public List<String> getcQoContents() {
        return cQoContents;
    }

    public void setcQoIds(List<String> cQoIds) {
        this.cQoIds = cQoIds;
    }

    public List<String> getcQoIds() {
        return cQoIds;
    }
}
