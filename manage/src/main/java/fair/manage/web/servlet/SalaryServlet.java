package fair.manage.web.servlet;

import fair.manage.dao.EngineerDao;
import fair.manage.dao.impl.EngineerDaoImpl;
import fair.manage.domain.*;
import fair.manage.service.EngineerService;
import fair.manage.service.SalaryService;
import fair.manage.service.impl.EngineerServiceImpl;
import fair.manage.service.impl.SalaryServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @version v1.0
 * @package fair.manage.web.servlet
 * @auther fair
 * @date 2020-02-29 上午 9:25
 */

@WebServlet("/salary/*")
public class SalaryServlet extends BaseServlet{
    SalaryService service = new SalaryServiceImpl();
    EngineerService engineerService = new EngineerServiceImpl();
    /**
     * 工资计算
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void calculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Salary salary = new Salary();
        try {
            BeanUtils.populate(salary, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        double money = service.calculate(salary);
        salary.setSalary(money);
        writeValue(salary, response);
    }

    /**
     * 工资保存
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        Map<String, String[]> map = request.getParameterMap();
        Salary salary = new Salary();
        try {
            BeanUtils.populate(salary, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        double money = service.calculate(salary);
        salary.setSalary(money);
        if(money != 0){
            service.save(salary);
            engineerService.updateSalary(salary.getId(), salary.getSalary());
            info.setFlag(true);
        }else {
            info.setFlag(false);
        }
        writeValue(info, response);
    }

    /**
     * 遍历工资列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        int currentPage = 1;
        if(currentPageStr != null && currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }

        int pageSize = 20;
        if(pageSizeStr != null && pageSizeStr.length() > 0){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        PageBean<EngineerSalary> pageBean = service.pageQuery(currentPage, pageSize);
        writeValue(pageBean, response);
    }
}
