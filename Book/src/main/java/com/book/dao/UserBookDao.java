package com.book.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.entity.Book;
import com.book.entity.User;
import com.book.entity.UserBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description:
 *
 * @author bai
 * @version 1.0.0
 * @date 2022/06/27 22:09:52
 */
public interface UserBookDao {

    int userBookInsert(UserBook userBook);

    UserBook query(UserBook userBook);

    List<UserBook> queryUserBookListByUserId(Page<UserBook> userBook, @Param(Constants.WRAPPER) QueryWrapper<Book> wrapper, @Param("userId") Integer userId);

    IPage<Book> queryUserBookListByUserIdIpage(Page<Book> userBook, @Param(Constants.WRAPPER) QueryWrapper<Book> wrapper);

    void deleteByBookId(Integer bookId);

    void alterTableBook(@Param("column") Integer column);

    void updateBookColumn(@Param("column") String column, @Param("userId") Integer userId, @Param("bookId") Integer bookId);

    Integer queryBookTestIdByBookInfo(Book book);

    Book queryBookTestByBookId(Integer bookId);
}
