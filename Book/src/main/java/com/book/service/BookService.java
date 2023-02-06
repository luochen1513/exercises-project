package com.book.service;

import com.book.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * (Book)表服务接口
 *
 * @author makejava
 * @since 2022-06-26 11:56:43
 */
public interface BookService {

    /**
     * 通过ID查询单条数据
     *
     * @param bookid 主键
     * @return 实例对象
     */
    Book queryById(Integer bookid);

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    Integer insert(Book book);

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    Integer update(Book book);

    /**
     * 通过主键删除数据
     *
     * @param bookid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bookid);

    Map<String, Object> queryPageList(Book book);

    void deleteBookTable();

    void createBookTable();

    void deleteBookTestTable();

    void createBookTestTable();

    Book queryRecommendBookByBookId(Integer bookId);

    Map<String, Object> queryBooksByBookId(Book book);
}
