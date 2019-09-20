package com.jiuyao.boot.entity;

import java.util.List;

public class Page<T> {

    private int pageSize = 1;//页码
    private int pageTotal;//总页数
    private int pageCount = 50;//每页显示个数
    private List<T> list;

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", pageTotal=" + pageTotal +
                ", pageCount=" + pageCount +
                ", list=" + list +
                '}';
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public int setPageTotal(int total) {

        int pt = total%pageCount == 0 ? total/pageCount : total/pageCount+1;

        this.pageTotal = pt;
        return pageTotal;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int calculatePageSize(int size){

        this.pageSize = size;

        if(size <= 0){
            this.pageSize = 1;
        }

        if(size >= this.pageTotal){
            this.pageSize = this.pageTotal;
        }
        return this.pageSize;
    }
}
