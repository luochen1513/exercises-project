package com.book.entity;

import com.book.dto.requestDto.PageDto;

import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author makejava
 * @since 2022-06-26 11:56:40
 */
public class Book extends PageDto implements Serializable {
    private static final long serialVersionUID = 114278756344356745L;
    
    private Integer bookid;
    
    private String name;
    
    private String score;
    
    private String price;
    
    private String publish;
    
    private String url;

    private String bookFileName;


    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBookFileName() {
        return bookFileName;
    }

    public void setBookFileName(String bookFileName) {
        this.bookFileName = bookFileName;
    }
}

