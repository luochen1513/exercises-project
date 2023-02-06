package com.book.service;

import com.book.dto.responseDto.LoginResponseDto;
import com.book.entity.User;

import java.util.List;
import java.util.Map;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-05-23 18:31:07
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    void insertAll(User user);
    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    Integer update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    LoginResponseDto getUserInfoByUsernameAndPassword(String username, String password);

    User queryByUsername(String username);

    void updatePassword(String username, String newPassword);

    Map<String, Object> queryPageList(User user);

    User queryByEmail(String email);

    User queryByPhone(String phone);

    void updateHit(Integer userId, Integer bookid);
}
