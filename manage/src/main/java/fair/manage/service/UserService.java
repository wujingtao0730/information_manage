package fair.manage.service;

import fair.manage.domain.User;

/**
 * @version v1.0
 * @package cn.itcast.travel.service
 * @auther fair
 * @date 2020-02-07 下午 13:53
 */
public interface UserService {
    //注册用户
    public boolean regist(User user);

    public boolean active(String code);

    public User login(User user);
}
