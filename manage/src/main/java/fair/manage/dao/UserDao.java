package fair.manage.dao;

import fair.manage.domain.Engineer;
import fair.manage.domain.User;

import java.util.List;

/**
 * @version v1.0
 * @package cn.itcast.travel.dao
 * @auther fair
 * @date 2020-02-07 下午 13:57
 */
public interface UserDao {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     */
    void save(User user);

    /**
     * 根据激活码查找用户
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 更新用户激活状态
     * @param user
     */
    void updateStatus(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);
}
