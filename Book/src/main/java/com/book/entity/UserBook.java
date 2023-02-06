package com.book.entity;

import java.io.Serializable;

/**
 * description:
 *
 * @author bai
 * @version 1.0.0
 * @date 2022/06/27 21:56:11
 */
public class UserBook extends Book implements Serializable{

    private static final long serialVersionUID = -10990236264829796L;
    private Integer id;

    private Integer userId;

    private Integer bookId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
