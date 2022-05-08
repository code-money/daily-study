package com.zyz.entity;

import java.util.List;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-07 10:57
 **/


//分页对象
public class PageBean<T> {
    private Integer totalCount;//总记录数
    private Integer totalPage;//总页数
    private List<T> list;//每页显示的数据
    private Integer currentPage;//当前页码
    private Integer rows;//每页显示记录数

    public PageBean() {
    }

    public PageBean(Integer totalCount, Integer totalPage, List<T> list, Integer currentPage, Integer rows) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
        this.currentPage = currentPage;
        this.rows = rows;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}



