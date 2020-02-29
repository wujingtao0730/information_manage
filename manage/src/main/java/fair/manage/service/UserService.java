package fair.manage.service;

import fair.manage.domain.User;

/**
 * @version v1.0
 * @package cn.itcast.travel.service
 * @auther fair
 * @date 2020-02-07 下午 13:53
 */
public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean regist(User user);

    /**
     * 用户激活
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean update(User user);
}
