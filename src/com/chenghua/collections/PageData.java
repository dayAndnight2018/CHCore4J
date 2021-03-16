package com.chenghua.collections;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 分页辅助类，不支持多线程
 * @param <T>
 */
public class PageData<T> {

    /**
     * 列表数据
     */
    private List<T> data;
    /**
     * 当前页
     */
    private long page;
    /**
     * 总数量
     */
    private long totalSize;
    /**
     * 页面大小
     */
    private long pageSize;

    /**
     * 总页数
     */
    private long totalPage;

    public PageData(List<T> data, long pageSize) {
        if (data == null) {
            throw new RuntimeException("data could not be null");
        }
        if (pageSize <= 0) {
            throw new RuntimeException("page size could not less than 0");
        }
        this.data = data;
        this.pageSize = pageSize;
        this.totalSize = data.size();
        this.page = 0;
        this.totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
    }

    public List<T> next() {
        if (hasNext()) {
            this.page++;
            return this.data.stream().skip((this.page - 1) * this.pageSize).limit(this.pageSize).collect(Collectors.toList());
        }
        throw new RuntimeException("out of bounds of page data");
    }

    public boolean hasNext() {
        return page < totalPage;
    }

    public List<T> last() {
        if (hasLast()) {
            this.page--;
            return this.data.stream().skip((this.page - 1) * this.pageSize).limit(this.pageSize).collect(Collectors.toList());
        }
        throw new RuntimeException("out of bounds of page data");
    }

    public boolean hasLast() {
        return page > 1;
    }

    public List<T> page(long page){
        if (page <= 0) {
            throw new RuntimeException("page could not less than 0");
        }
        return this.data.stream().skip((page - 1) * this.pageSize).limit(this.pageSize).collect(Collectors.toList());
    }

    public List<T> page(long page, long pageSize){
        if (page <= 0 || pageSize <= 0) {
            throw new RuntimeException("page or page size could not less than 0");
        }
        return this.data.stream().skip((page - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
    }
}
