package com.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.dao.HitDao;
import com.book.dao.UserDao;
import com.book.dto.responseDto.LoginResponseDto;
import com.book.entity.Book;
import com.book.entity.Hit;
import com.book.entity.User;
import com.book.service.UserService;
import com.book.util.Md5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-05-23 18:31:07
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private HitDao hitDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userId) {
        return this.userDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    @Override
    public void insertAll(User user) {
        user.setPassword(Md5Util.getMd5(user.getPassword()));
        userDao.insertAll(user);
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(User user) {
        return userDao.update(user);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public LoginResponseDto getUserInfoByUsernameAndPassword(String username, String password) {
        return userDao.getUserInfoByUsernameAndPassword(username, Md5Util.getMd5(password));
    }

    @Override
    public User queryByUsername(String username) {
        return userDao.queryByUsername(username);
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        userDao.updatePassword(username, Md5Util.getMd5(newPassword));
    }

    @Override
    public Map<String, Object> queryPageList(User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            if (user.getUsername() != null) {
                wrapper.like("username", user.getUsername());
            }
            Page<User> page = new Page<>(user.getCurrent(), user.getSize());
            IPage<User> userList = userDao.queryPageList(page, wrapper);

            map.put("success", true);
            map.put("data", userList);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            //如果用到Spring的事物声明,则需要的catch中捕获后抛出,否则事物失效
        }
        return map;
    }

    @Override
    public User queryByEmail(String email) {
        return userDao.queryByEmail(email);
    }

    @Override
    public User queryByPhone(String phone) {
        return userDao.queryByPhone(phone);
    }

    /**
     * nested exception is org.apache.ibatis.binding.BindingException: Parameter 'userId' not found.
     * Available parameters are [arg1, arg0, param1, param2]
     *
     * nested exception is org.apache.ibatis.executor.ExecutorException: Error getting generated key
     * or setting result to parameter object. Cause: org.apache.ibatis.executor.ExecutorException:
     * Could not determine which parameter to assign generated keys to. Note that when there are
     * multiple parameters, 'keyProperty' must include the parameter name (e.g. 'param.id'). Specified
     * key properties are [hitId] and available parameters are [hit, param3, userId, param1, bookId,
     * param2]
     */
    @Override
    public void updateHit(Integer userId, Integer bookid) {
        Hit query = hitDao.queryByUserIdBookId(userId, bookid);
        if (query == null) {
            Hit hit = new Hit();
            hit.setHit(1);
            hit.setUserId(userId);
            hit.setBookId(bookid);
            hitDao.insert(hit);
        } else {
            hitDao.update(userId, bookid, query.getHit() + 1);
        }
    }
}
