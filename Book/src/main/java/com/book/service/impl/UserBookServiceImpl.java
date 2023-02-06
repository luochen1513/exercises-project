package com.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.dao.BookDao;
import com.book.dao.UserBookDao;
import com.book.dao.UserDao;
import com.book.entity.Book;
import com.book.entity.UserBook;
import com.book.service.UserBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * description:
 *
 * @author bai
 * @version 1.0.0
 * @date 2022/06/27 22:12:07
 */
@Service("userBookService")
public class UserBookServiceImpl implements UserBookService {

    @Resource
    private UserBookDao userBookDao;

    @Resource
    private UserDao userDao;

    @Resource
    private BookDao bookDao;

    /**
     * 添加失败~ ### Error updating database. Cause: java.sql.SQLSyntaxErrorException: You have an error
     * in your SQL syntax; check the manual that corresponds to your MySQL server version for the right
     * syntax to use near ''李四2' varchar(200)' at line 2 ### The error may exist in file [D:\IDEA\
     * study\keshe\Book\target\classes\mappers\UserBookDao.xml] ### The error may involve
     * defaultParameterMap ### The error occurred while setting parameters ### SQL: alter table
     * book.book add ? varchar(200) ### Cause: java.sql.SQLSyntaxErrorException: You have an error in
     * your SQL syntax; check the manual that corresponds to your MySQL server version for the right
     * syntax to use near ''李四2' varchar(200)' at line 2 ; bad SQL grammar []; nested exception is
     * java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that
     * corresponds to your MySQL server version for the right syntax to use near ''李四2' varchar(200)'
     * at line 2
     */
    @Override
    public Map<String, Object> userBookInsert(UserBook userBook) {
        Map<String, Object> map = new HashMap<>();
        Book book = bookDao.queryById(userBook.getBookId());
        Integer bookId = userBookDao.queryBookTestIdByBookInfo(book);
        //userId+bookId
        bookDao.deleteById(userBook.getBookId());
        userBook.setBookId(bookId);
        UserBook query = userBookDao.query(userBook);
        if (query==null){
            userBookDao.userBookInsert(userBook);
            map.put("success", true);
            return map;
        }else {
            map.put("success", false);
            return map;
        }
    }

    @Override
    public UserBook query(UserBook userBook) {
        return userBookDao.query(userBook);
    }

    @Override
    public Map<String, Object> queryBooksByUserId(Book book, Integer userId) {
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        if (book.getName() != null) {
            wrapper.like("name", book.getName());
        }
        if (book.getPublish() != null) {
            wrapper.like("publish", book.getPublish());
        }
        wrapper.eq("userId", userId).last("and book_test.bookId=user_book.bookId");
        Page<Book> page = new Page<>(book.getCurrent(), book.getSize());
        IPage<Book> userBookListIpage = userBookDao.queryUserBookListByUserIdIpage(page, wrapper);
        map.put("success", true);
        map.put("userBookListIpage", userBookListIpage);
        return map;
    }

    @Override
    public void deleteByBookId(Integer bookId) {
        Book book =userBookDao.queryBookTestByBookId(bookId);
        userBookDao.deleteByBookId(bookId);
        bookDao.insert(book);
    }
}
