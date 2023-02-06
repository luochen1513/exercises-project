package com.book.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.entity.Book;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Book)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-26 11:56:40
 */
public interface BookDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bookid 主键
     * @return 实例对象
     */
    Book queryById(Integer bookid);

    /**
     * 统计总行数
     *
     * @param book 查询条件
     * @return 总行数
     */
    long count(Book book);

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 影响行数
     */
    int insert(Book book);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Book> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Book> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Book> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Book> entities);

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 影响行数
     */
    int update(Book book);

    /**
     * 通过主键删除数据
     *
     * @param bookid 主键
     * @return 影响行数
     */
    int deleteById(Integer bookid);

    IPage<Book> queryPageList(Page<Book> book, @Param(Constants.WRAPPER) QueryWrapper<Book> wrapper);

    void deleteBookTable();

    void createBookTable();

    void createBookTestTable();

    void deleteBookTestTable();

    Book queryRecommendBookByBookId(@Param("bookId")Integer bookId);

    IPage<Book> queryRecommendBookList(Page<Book> page,@Param("bookId") Integer bookId);
}

