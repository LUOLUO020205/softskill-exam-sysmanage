package com.softskill.exam.vo;

import com.softskill.exam.domain.QuestionOptions;

public class QuestionOptionsVo extends QuestionOptions {

    private boolean validateOptionFlag;

    public void setValidateOptionFlag(boolean validateOptionFlag) {
        this.validateOptionFlag = validateOptionFlag;
    }

    public boolean isValidateOptionFlag() {
        return validateOptionFlag;
    }
}
