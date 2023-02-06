package com.book.dao;

import com.book.entity.Hit;
import org.apache.ibatis.annotations.Param;

/**
 * description:
 *
 * @author bai
 * @version 1.0.0
 * @date 2022/06/29 22:27:53
 */
public interface HitDao {

    Hit queryByUserIdBookId(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    void update(@Param("userId") Integer userId, @Param("bookId") Integer bookId, @Param("hit") int hit);

    void insert(Hit hit);
}
