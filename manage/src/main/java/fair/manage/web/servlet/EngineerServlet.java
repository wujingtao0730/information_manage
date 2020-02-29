package fair.manage.web.servlet;

import fair.manage.domain.Engineer;
import fair.manage.domain.PageBean;
import fair.manage.domain.ResultInfo;
import fair.manage.domain.Salary;
import fair.manage.service.EngineerService;
import fair.manage.service.SalaryService;
import fair.manage.service.impl.EngineerServiceImpl;
import fair.manage.service.impl.SalaryServiceImpl;
import fair.manage.util.ExcleUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @version v1.0
 * @package fair.manage.web.servlet
 * @auther fair
 * @date 2020-02-27 下午 16:46
 */
@WebServlet("/engineer/*")
public class EngineerServlet extends BaseServlet{
    EngineerService service = new EngineerServiceImpl();
    SalaryService salaryService = new SalaryServiceImpl();
    /**
     * 保存数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void saveInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        Engineer engineer = new Engineer();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(engineer, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean flag = service.save(engineer);
        salaryService.create(engineer);
        if(flag){
            info.setFlag(true);
        }else {
            info.setFlag(false);
            info.setErrorMsg("保存失败");
        }
        writeValue(info, response);
    }

    /**
     * 修改数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        Engineer engineer = new Engineer();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(engineer, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean flag = service.update(engineer);
        if(flag){
            info.setFlag(true);
            salaryService.update(engineer);
        }else {
            info.setFlag(false);
            info.setErrorMsg("工号不存在");
        }
        writeValue(info, response);
    }

    /**
     * 删除信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        Engineer engineer = new Engineer();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(engineer, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean flag = service.delete(engineer.getId());
        if(flag){
            info.setFlag(true);
            salaryService.delete(engineer.getId());
        }else {
            info.setFlag(false);
            info.setErrorMsg("工号不存在");
        }
        writeValue(info, response);
    }

    /**
     * 查找单个工程师
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Engineer engineer = service.findById(id);
        writeValue(engineer, response);
    }

    /**
     * 将数据库中工程师信息导出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void infoExport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Engineer> list = service.findAll();
        ExcleUtils utils = new ExcleUtils();
        utils.excleOut(list);
    }

    /**
     * 将excel的信息导入数据库
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void infoImport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExcleUtils utils = new ExcleUtils();
        List list = utils.excleIn();
        Engineer engineer = new Engineer();
        for (int i = 0; i < list.size(); i++) {
            engineer = (Engineer) list.get(i);
            Engineer en = service.findById(engineer.getId());
            if(en == null){
                service.save(engineer);
                salaryService.create(engineer);
            }else {
                continue;
            }
        }
    }

    /**
     * 查询所有记录数
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Engineer> list = service.findAll();
        writeValue(list, response);
    }

    /**
     * 分页查询
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
        PageBean<Engineer> pageBean = service.pageQuery(currentPage, pageSize);
        writeValue(pageBean, response);
    }

    /**
     * 按照工龄分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQueryByYears(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        PageBean<Engineer> pageBean = service.pageQueryByYears(currentPage, pageSize);
        writeValue(pageBean, response);
    }

    /**
     * 按照名字分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQueryByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        PageBean<Engineer> pageBean = service.pageQueryByName(currentPage, pageSize);
        writeValue(pageBean, response);
    }

    /**
     * 按照薪水分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQueryBySalary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        PageBean<Engineer> pageBean = service.pageQueryBySalary(currentPage, pageSize);
        writeValue(pageBean, response);
    }
}
