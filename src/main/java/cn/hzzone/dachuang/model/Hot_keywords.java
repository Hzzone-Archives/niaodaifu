package cn.hzzone.dachuang.model;

public class Hot_keywords {
    private String keywordsId;

    private String keywords;

    public String getKeywordsId() {
        return keywordsId;
    }

    public void setKeywordsId(String keywordsId) {
        this.keywordsId = keywordsId == null ? null : keywordsId.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }
}