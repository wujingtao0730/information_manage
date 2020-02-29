package fair.manage.service.impl;

import fair.manage.dao.UserDao;
import fair.manage.dao.impl.UserDaoImpl;
import fair.manage.domain.User;
import fair.manage.service.UserService;
import fair.manage.util.MailUtils;
import fair.manage.util.UuidUtil;

/**
 * @version v1.0
 * @package cn.itcast.travel.service.impl
 * @auther fair
 * @date 2020-02-07 下午 13:56
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        User u = dao.findByUsername(user.getUsername());
        if(u == null){
            user.setCode(UuidUtil.getUuid());
            user.setStatus("N");
            dao.save(user);
            String content = "<a href='http://localhost/manage/user/active?code="+user.getCode()+"'>点击激活</a>";
            MailUtils.sendMail(user.getEmail(), content, "激活邮件");
            return true;
        }else {
            return false;
        }
    }

    /**
     * 激活用户
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        User user = dao.findByCode(code);
        if(user != null){
            dao.updateStatus(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        User u = dao.login(user);
        return u;
    }

    @Override
    public boolean update(User user) {
        User u  = dao.findByUsername(user.getUsername());
        if(u != null){
            dao.update(user);
            return true;
        }
        return false;
    }
}
