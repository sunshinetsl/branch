package com.dragon.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/7/2 0002.
 */
@SuppressWarnings("ALL")
public class BaseSearchConditionDTO<T> implements Serializable{

    //每页记录数
    private int countPerPage;

    //页号
    private int pageIndex;

    //总页数
    private long totalPage;

    //总记录数
    private long totalRows;

    private List<T> resultList;

    public int getCountPerPage() {
        return countPerPage;
    }

    public void setCountPerPage(int countPerPage) {
        this.countPerPage = countPerPage;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
}
