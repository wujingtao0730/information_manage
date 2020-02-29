package fair.manage.service.impl;

import fair.manage.dao.EngineerDao;
import fair.manage.dao.SalaryDao;
import fair.manage.dao.impl.EngineerDaoImpl;
import fair.manage.dao.impl.SalaryDaoImpl;
import fair.manage.domain.Engineer;
import fair.manage.domain.EngineerSalary;
import fair.manage.domain.PageBean;
import fair.manage.domain.Salary;
import fair.manage.service.SalaryService;
import fair.manage.util.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @package fair.manage.service.impl
 * @auther fair
 * @date 2020-02-29 上午 9:46
 */
public class SalaryServiceImpl implements SalaryService {
    EngineerDao engineerDao = new EngineerDaoImpl();
    SalaryDao dao = new SalaryDaoImpl();
    BeanUtils utils = new BeanUtils();
    double money = 0;
    @Override
    public double calculate(Salary salary) {
        Engineer engineer = engineerDao.findById(salary.getId());
        if(engineer != null){
            getBase_pay(engineer, salary);
            double base_pay = salary.getBase_pay();
            int working_years = engineer.getWorking_years();
            money = (base_pay * salary.getWorking_days()) - salary.getInsurance() + (working_years * 1000);
            return money;
        }
        return money;
    }

    @Override
    public void save(Salary salary) {
        Salary sal = dao.findById(salary.getId());
        if(salary == null){
            dao.save(salary);
        }else {
            dao.update(salary);
        }
    }

    @Override
    public PageBean<EngineerSalary> pageQuery(int currentPage, int pageSize) {
        EngineerDao engineerDao = new EngineerDaoImpl();
        PageBean<EngineerSalary> bean = new PageBean<EngineerSalary>();
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
        List<EngineerSalary> list = new ArrayList<EngineerSalary>();
        List<Salary> salaries = dao.findByPage(start, pageSize);
        for (Salary salary : salaries) {
            Engineer engineer = engineerDao.findById(salary.getId());
            EngineerSalary engineerSalary = utils.packaging(salary, engineer);
            list.add(engineerSalary);
        }
        bean.setList(list);
        return bean;
    }

    @Override
    public void create(Engineer engineer) {
        Salary salary = new Salary();
        salary.setInsurance(500);
        salary.setId(engineer.getId());
        getBase_pay(engineer, salary);
        salary.setWorking_days(25);
        salary.setSalary(engineer.getSalary());
        dao.save(salary);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public void update(Engineer engineer) {
        Salary salary = new Salary();
        salary.setInsurance(500);
        salary.setId(engineer.getId());
        getBase_pay(engineer, salary);
        salary.setWorking_days(25);
        salary.setSalary(engineer.getSalary());
        dao.update(salary);
    }

    private void getBase_pay(Engineer engineer, Salary salary) {
        String education = engineer.getEducation();
        if ("中专".equals(education)) {
            salary.setBase_pay(100.00);
        } else if ("专科".equals(education)) {
            salary.setBase_pay(200.00);
        } else if ("本科".equals(education)) {
            salary.setBase_pay(300.00);
        } else if ("高中".equals(education)) {
            salary.setBase_pay(70.00);
        } else if ("硕士".equals(education)) {
            salary.setBase_pay(400.00);
        } else if ("博士".equals(education)) {
            salary.setBase_pay(500.00);
        }
    }
}
