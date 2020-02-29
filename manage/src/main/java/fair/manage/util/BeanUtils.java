package fair.manage.util;

import fair.manage.domain.Engineer;
import fair.manage.domain.EngineerSalary;
import fair.manage.domain.Salary;

/**
 * @version v1.0
 * @package fair.manage.util
 * @auther fair
 * @date 2020-02-29 上午 11:38
 */
public class BeanUtils {
    public EngineerSalary packaging(Salary salary, Engineer engineer){
        /**
         * 获取数据
         */
        EngineerSalary engineerSalary = new EngineerSalary();
        String id = salary.getId();
        int working_days = salary.getWorking_days();
        double base_pay = salary.getBase_pay();
        double insurance = salary.getInsurance();
        double money = salary.getSalary();
        String education = engineer.getEducation();
        String name = engineer.getName();
        String telephone = engineer.getTelephone();
        int working_years = engineer.getWorking_years();

        /**
         * 封装数据
         */
        engineerSalary.setId(id);
        engineerSalary.setName(name);
        engineerSalary.setEducation(education);
        engineerSalary.setTelephone(telephone);
        engineerSalary.setWorking_years(working_years);
        engineerSalary.setBase_pay(base_pay);
        engineerSalary.setWorking_days(working_days);
        engineerSalary.setInsurance(insurance);
        engineerSalary.setSalary(money);

        return engineerSalary;
    }
}
