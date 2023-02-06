package com.book.entity;

import java.io.Serializable;

/**
 * description:
 *
 * @author bai
 * @version 1.0.0
 * @date 2022/06/29 22:25:11
 */
public class Hit implements Serializable {

    private static final long serialVersionUID = -2556813038872356891L;

    private Integer hitId;

    private Integer userId;

    private Integer bookId;

    private Integer hit;

    public Integer getHitId() {
        return hitId;
    }

    public void setHitId(Integer hitId) {
        this.hitId = hitId;
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

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }
}
