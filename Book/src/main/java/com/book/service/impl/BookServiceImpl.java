package com.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.entity.Book;
import com.book.dao.BookDao;
import com.book.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Book)表服务实现类
 *
 * @author makejava
 * @since 2022-06-26 11:56:43
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bookid 主键
     * @return 实例对象
     */
    @Override
    public Book queryById(Integer bookid) {
        return this.bookDao.queryById(bookid);
    }

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(Book book) {
        return bookDao.insert(book);
    }

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(Book book) {
        return bookDao.update(book);
    }

    /**
     * 通过主键删除数据
     *
     * @param bookid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bookid) {
        return this.bookDao.deleteById(bookid) > 0;
    }

    @Override
    public Map<String, Object> queryPageList(Book book) {
        Map<String, Object> map = new HashMap<>();
        try {
            QueryWrapper<Book> wrapper = new QueryWrapper<>();
            if (book.getName() != null) {
                wrapper.like("name", book.getName());
            }
            if (book.getPublish() != null) {
                wrapper.like("publish", book.getPublish());
            }
            Page<Book> page = new Page<>(book.getCurrent(), book.getSize());
            IPage<Book> bookList = bookDao.queryPageList(page, wrapper);

            map.put("success", true);
            map.put("data", bookList);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            //如果用到Spring的事物声明,则需要的catch中捕获后抛出,否则事物失效
        }
        return map;
    }

    @Override
    public void deleteBookTable() {
        bookDao.deleteBookTable();
    }

    @Override
    public void createBookTable() {
        bookDao.createBookTable();
    }

    @Override
    public void deleteBookTestTable() {
        bookDao.deleteBookTestTable();
    }

    @Override
    public void createBookTestTable() {
        bookDao.createBookTestTable();
    }

    @Override
    public Book queryRecommendBookByBookId(Integer bookId) {
        return bookDao.queryRecommendBookByBookId(bookId);
    }

    @Override
    public Map<String, Object> queryBooksByBookId(Book book) {
        Map<String, Object> map = new HashMap<>();
        try {
            Page<Book> page = new Page<>(book.getCurrent(), book.getSize());
            IPage<Book> bookList = bookDao.queryRecommendBookList(page, book.getBookid());
            map.put("success", true);
            map.put("data", bookList);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            //如果用到Spring的事物声明,则需要的catch中捕获后抛出,否则事物失效
        }
        return map;
    }
}
