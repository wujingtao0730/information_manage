package fair.manage.web.servlet;

import fair.manage.domain.ResultInfo;
import fair.manage.domain.User;
import fair.manage.service.UserService;
import fair.manage.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @version v1.0
 * @package ${PACKAGE_NAME}
 * @auther fair
 * @date 2020-02-07 下午 19:32
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    /**
     * 注册功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(check.equalsIgnoreCase(checkcode_server)){
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            try {
                BeanUtils.populate(user, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            UserService service = new UserServiceImpl();
            boolean flag = service.regist(user);
            if(flag){
                info.setFlag(true);
            }else {
                info.setFlag(false);
                info.setErrorMsg("注册失败");
            }
            writeValue(info, response);
        }else {
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            writeValue(info, response);
        }
    }

    /**
     * 登录功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if (check.equalsIgnoreCase(checkcode_server)) {
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            try {
                BeanUtils.populate(user, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            UserService service = new UserServiceImpl();
            User u = service.login(user);

            if(u == null){
                info.setFlag(false);
                info.setErrorMsg("用户名密码或错误");
            }
            if(u != null && !"Y".equals(u.getStatus())){
                //用户尚未激活
                info.setFlag(false);
                info.setErrorMsg("您尚未激活，请激活");
            }
            if(u != null && "Y".equals(u.getStatus())){
                request.getSession().setAttribute("user",u);
                info.setFlag(true);
            }
            writeValue(info, response);
        }else {
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            writeValue(info, response);
        }
    }

    /**
     * 激活功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if(code != null && code.length() > 0){
            UserService service = new UserServiceImpl();
            boolean flag = service.active(code);
            String msg = null;
            if(flag){
                msg = "激活成功，请<a href='http://localhost/manage/index.html'>登录</a>";
            }else {
                msg = "激活失败，请联系管理员";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }

    /**
     * 退出功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    /**
     * 查询用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getSession().getAttribute("user");
        writeValue(user, response);
    }
}
