package fair.manage.domain;

import java.util.List;

/**
 * @version v1.0
 * @package cn.itcast.travel.domain
 * @auther fair
 * @date 2020-02-07 下午 21:26
 */
public class PageBean<T> {
    private int totalCount;
    private int totalPage;
    private int currentPage;
    private int pageSize;
    private List<T> list;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
