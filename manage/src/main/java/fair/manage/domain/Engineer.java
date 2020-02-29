package fair.manage.domain;

import java.util.Date;

/**
 * @version v1.0
 * @package fair.manage.domain
 * @auther fair
 * @date 2020-02-27 下午 16:32
 */
public class Engineer {
    private String id; //工程师工号
    private String name; //工程师姓名
    private String sex; //性别
    private String birthday; // 出生日期
    private String address; //地址
    private String education; //学历
    private String telephone; //电话号码
    private int working_years; //工龄
    private double salary; //薪水

    @Override
    public String toString() {
        return "Engineer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", education='" + education + '\'' +
                ", telephone='" + telephone + '\'' +
                ", working_years=" + working_years +
                ", salary=" + salary +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getWorking_years() {
        return working_years;
    }

    public void setWorking_years(int working_years) {
        this.working_years = working_years;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
