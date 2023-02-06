package com.book.service;

import com.book.entity.Book;
import com.book.entity.UserBook;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author bai
 * @version 1.0.0
 * @date 2022/06/27 22:10:48
 */
public interface UserBookService {

    Map<String, Object> userBookInsert(UserBook userBook);

    UserBook query(UserBook userBook);

    Map<String, Object> queryBooksByUserId(Book book,Integer userId);

    void deleteByBookId(Integer bookId);

}
