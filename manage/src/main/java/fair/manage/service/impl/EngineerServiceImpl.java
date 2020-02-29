package fair.manage.service.impl;

import fair.manage.dao.EngineerDao;
import fair.manage.dao.impl.EngineerDaoImpl;
import fair.manage.domain.Engineer;
import fair.manage.domain.PageBean;
import fair.manage.service.EngineerService;

import java.util.List;

/**
 * @version v1.0
 * @package fair.manage.service.impl
 * @auther fair
 * @date 2020-02-27 下午 16:46
 */
public class EngineerServiceImpl implements EngineerService {
    EngineerDao dao = new EngineerDaoImpl();

    @Override
    public boolean save(Engineer engineer) {
        dao.save(engineer);
        return true;
    }

    @Override
    public boolean update(Engineer engineer) {
        Engineer en = dao.findById(engineer.getId());
        if(en != null){
            dao.update(engineer);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        Engineer en = dao.findById(id);
        if(en != null){
            dao.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public Engineer findById(String id) {
        Engineer engineer = dao.findById(id);
        return engineer;
    }

    @Override
    public List<Engineer> findAll() {
        List<Engineer> list = dao.findAll();
        return list;
    }

    @Override
    public PageBean<Engineer> pageQuery(int currentPage, int pageSize) {
        PageBean<Engineer> bean = new PageBean<Engineer>();
        bean.setCurrentPage(currentPage);
        bean.setPageSize(pageSize);
        int count = dao.findTotalCount();
        bean.setTotalCount(count);
        int totalPage = count % pageSize == 0 ? count / pageSize :(count / pageSize) + 1 ;
        bean.setTotalPage(totalPage);
        int start = (currentPage - 1) * pageSize;
        if(start < 0){
            start = 0;
        }
        List<Engineer> list = dao.findByPage(start, pageSize);
        bean.setList(list);
        return bean;
    }

    @Override
    public PageBean<Engineer> pageQueryByName(int currentPage, int pageSize) {
        PageBean<Engineer> bean = new PageBean<Engineer>();
        bean.setCurrentPage(currentPage);
        bean.setPageSize(pageSize);
        int count = dao.findTotalCount();
        bean.setTotalCount(count);
        int totalPage = count % pageSize == 0 ? count / pageSize :(count / pageSize) + 1 ;
        bean.setTotalPage(totalPage);
        int start = (currentPage - 1) * pageSize;
        if(start < 0){
            start = 0;
        }
        List<Engineer> list = dao.findOrderByName(start, pageSize);
        bean.setList(list);
        return bean;
    }

    @Override
    public PageBean<Engineer> pageQueryByYears(int currentPage, int pageSize) {
        PageBean<Engineer> bean = new PageBean<Engineer>();
        bean.setCurrentPage(currentPage);
        bean.setPageSize(pageSize);
        int count = dao.findTotalCount();
        bean.setTotalCount(count);
        int totalPage = count % pageSize == 0 ? count / pageSize :(count / pageSize) + 1 ;
        bean.setTotalPage(totalPage);
        int start = (currentPage - 1) * pageSize;
        if(start < 0){
            start = 0;
        }
        List<Engineer> list = dao.findOrderByYears(start, pageSize);
        bean.setList(list);
        return bean;
    }

    @Override
    public void updateSalary(String id, double salary) {
        dao.updateSalary(id, salary);
    }

    @Override
    public PageBean<Engineer> pageQueryBySalary(int currentPage, int pageSize) {
        PageBean<Engineer> bean = new PageBean<Engineer>();
        bean.setCurrentPage(currentPage);
        bean.setPageSize(pageSize);
        int count = dao.findTotalCount();
        bean.setTotalCount(count);
        int totalPage = count % pageSize == 0 ? count / pageSize :(count / pageSize) + 1 ;
        bean.setTotalPage(totalPage);
        int start = (currentPage - 1) * pageSize;
        if(start < 0){
            start = 0;
        }
        List<Engineer> list = dao.findOrderBySalary(start, pageSize);
        bean.setList(list);
        return bean;
    }
}
