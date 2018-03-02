package com.hx.reader.model.vo;

/**
 * @Author yanuun
 * @Date 17:49 2018/2/28
 **/

public class JyEnWordInfoVO {
    private Integer id;

    private String word;

    private String soundmark;

    private String explainText;

    private String soundmarkUK;

    private String soundmarkUS;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoundmark() {
        return soundmark;
    }

    public void setSoundmark(String soundmark) {
        this.soundmark = soundmark;
    }

    public String getExplainText() {
        return explainText;
    }

    public void setExplainText(String explainText) {
        this.explainText = explainText;
    }

    public String getSoundmarkUK() {
        return soundmarkUK;
    }

    public void setSoundmarkUK(String soundmarkUK) {
        this.soundmarkUK = soundmarkUK;
    }

    public String getSoundmarkUS() {
        return soundmarkUS;
    }

    public void setSoundmarkUS(String soundmarkUS) {
        this.soundmarkUS = soundmarkUS;
    }
}
