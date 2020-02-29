package fair.manage.util;

import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

import fair.manage.domain.Engineer;
import jxl.Cell;

import jxl.Sheet;

import jxl.Workbook;

import jxl.write.Label;

import jxl.write.WritableSheet;

import jxl.write.WritableWorkbook;

import jxl.write.WriteException;



public class ExcleUtils {
    /**
     * 将list集合中的数据导出到Excel中
     * @param list
     */
    public void excleOut(List list) {
        WritableWorkbook workbook =null;
        try {
            // 创建一个excle工作簿对象
            workbook = Workbook.createWorkbook(new File("D:/engineer.xls"));

            // 通过excle对象创建一个选项卡对象
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            Label label01 = new Label(0, 0, "工号");
            Label label02 = new Label(1, 0, "姓名");
            Label label03 = new Label(2, 0, "性别");
            Label label04 = new Label(3, 0, "生日");
            Label label05 = new Label(4, 0, "地址");
            Label label06 = new Label(5, 0, "学历");
            Label label07 = new Label(6, 0, "电话");
            Label label08 = new Label(7, 0, "工龄");
            Label label09 = new Label(8, 0, "薪水");

            // 将创建好的单元格对象放入选项卡中
            sheet.addCell(label01);
            sheet.addCell(label02);
            sheet.addCell(label03);
            sheet.addCell(label04);
            sheet.addCell(label05);
            sheet.addCell(label06);
            sheet.addCell(label07);
            sheet.addCell(label08);
            sheet.addCell(label09);
            // 创建一个单元格对象 列 行 值
            for (int i = 0; i < list.size(); i++) {
                Engineer engineer_t = (Engineer) list.get(i);
                Label label1 = new Label(0, i+1, String.valueOf(engineer_t.getId()));
                Label label2 = new Label(1, i+1, engineer_t.getName());
                Label label3 = new Label(2, i+1, engineer_t.getSex());
                Label label4 = new Label(3, i+1, engineer_t.getBirthday());
                Label label5 = new Label(4, i+1, engineer_t.getAddress());
                Label label6 = new Label(5, i+1, engineer_t.getEducation());
                Label label7 = new Label(6, i+1, engineer_t.getTelephone());
                Label label8 = new Label(7, i+1, Integer.toString(engineer_t.getWorking_years()));
                Label label9 = new Label(8, i+1, ""+engineer_t.getSalary());

                // 将创建好的单元格对象放入选项卡中
                sheet.addCell(label1);
                sheet.addCell(label2);
                sheet.addCell(label3);
                sheet.addCell(label4);
                sheet.addCell(label5);
                sheet.addCell(label6);
                sheet.addCell(label7);
                sheet.addCell(label8);
                sheet.addCell(label9);
            }

            // 写入目标路径
            workbook.write();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                workbook.close();
            }catch (IOException | WriteException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将Excel中的数据导入到list集合中
     * @return
     */
    public List excleIn() {
        List list =new ArrayList<>();
        Workbook workbook =null;
        try {
            // 获取Ecle对象
            workbook = Workbook.getWorkbook(new File("D:/engineer.xls"));
            // 获取选项卡对象 第0个选项卡
            Sheet sheet = workbook.getSheet(0);
            // 循环选项卡中的值
            for (int i = 1; i < sheet.getRows(); i++) {
                Engineer engineer_w =new Engineer();
                // 获取单元格对象
                Cell cell0 = sheet.getCell(0, i);
                // 取得单元格的值,并设置到对象中
                engineer_w.setId(cell0.getContents());
                // 获取单元格对象，然后取得单元格的值,并设置到对象中
                engineer_w.setName(sheet.getCell(1, i).getContents());
                engineer_w.setSex(sheet.getCell(2, i).getContents());
                engineer_w.setBirthday(sheet.getCell(3, i).getContents());
                engineer_w.setAddress(sheet.getCell(4, i).getContents());
                engineer_w.setEducation(sheet.getCell(5, i).getContents());
                engineer_w.setTelephone(sheet.getCell(6, i).getContents());
                engineer_w.setWorking_years(Integer.valueOf(sheet.getCell(7, i).getContents()));
                engineer_w.setSalary(Double.parseDouble(sheet.getCell(8, i).getContents()));
                list.add(engineer_w);
            }
         }catch (Exception e) {
            e.printStackTrace();
        }finally {
            workbook.close();
        }
        return list;
    }
}


