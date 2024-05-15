package com.homerunball.admin.stock.domain;

import java.util.Objects;

public class SearchCondition {
    private String option = "";
    private String keyword ="";

    public SearchCondition(){}

    public SearchCondition(String option, String keyword) {
        this.option = option;
        this.keyword = keyword;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchCondition that = (SearchCondition) o;
        return Objects.equals(option, that.option) && Objects.equals(keyword, that.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(option, keyword);
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "option='" + option + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
