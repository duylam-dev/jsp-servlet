package com.javaweb.paging;

import com.javaweb.sort.Sorter;

public class PageRequest implements Pageble{
    private Integer Page;
    private Integer maxPageItem;
    private Sorter sorter;
    public PageRequest(Integer Page, Integer maxPageItem, Sorter sorter){
        this.Page = Page;
        this.maxPageItem = maxPageItem;
        this.sorter = sorter;
    }
    @Override
    public Integer getPage() {
        return this.Page;
    }

    @Override
    public Integer getOffset() {
        if(this.Page != null && this.maxPageItem != null) return (this.Page - 1) * this.maxPageItem;
       else return null;
    }

    @Override
    public Integer getLimit() {
        return this.maxPageItem;
    }

    @Override
    public Sorter getSorter() {
        if(this.sorter != null) return this.sorter;
        return null;
    }


}
