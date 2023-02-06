package com.book.dto.requestDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bai
 * @date: 2022/4/24 11:01
 * @description:
 */
@ApiModel(description = "分页")
public class PageDto implements Serializable {

    private static final long serialVersionUID = -4007221956328749507L;

    @ApiModelProperty(value = "数据总量")
    private Long total;

    @ApiModelProperty(value = "总页数")
    private Long pages;

    @ApiModelProperty(value = "当前页")
    private Long current = 1L;

    @ApiModelProperty(value = "每页数量")
    private Long size = 10L;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
