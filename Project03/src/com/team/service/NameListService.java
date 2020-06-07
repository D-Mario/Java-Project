package com.team.service;

import com.team.domain.*;

import static com.team.service.Data.*;

/*
 * @Description:负责将data中的数据服装到Employee[]数组中，同时提供相关操作Employee[]方法。
 * @author: Dario
 * @version:
 * @date: 2020/6/6 18:52
 */
public class NameListService {
    private Employee[] employees;
    /*
     * @Description:给employess及数组元素进行初始化
     * @author: Dario
     * @version:
     * @date: 2020/6/6 18:52
     */
    /*
     * @Description:
     * @author: Dario
     * @version:
     * @date: 2020/6/6 18:55
     * @return: 
     * 
     */
    public  NameListService(){
//  1.根据提供的Data类构建相应大小的employees数组
//  2.再根据Data类中数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象。
//  3.将对象存于数组中
    employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            //获取员工的类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            //获取Employee的4个基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            Equipment equipment;
            double bonus;
            int stock;

            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i]  = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }
    /*
     * @Description:获取指定index上的员工的设备
     * @author: Dario
     * @version:
     * @date: 2020/6/6 19:11
     * @param index
     * @return: com.team.domain.Equipment
     */
    private Equipment createEquipment(int index) {

        int key = Integer.parseInt(EQUIPMENTS[index][0]);

        String modelOrName = EQUIPMENTS[index][1];
        switch (key){
            case PC:
                String display = EQUIPMENTS[index][2];
                return new PC(modelOrName,display);
            case NOTEBOOK:
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return  new NoteBook(modelOrName,price);
            case PRINTER:
                String type = EQUIPMENTS[index][2];
                return  new Printer(modelOrName,type);
        }
        return null;
    }
/*
 * @Description:获取当前所有的员工
 * @author: Dario
 * @version:
 * @date: 2020/6/6 20:18
 * @return: com.team.domain.Employee[]
 */
    public Employee[] getAllEmployees(){
        return employees;
    }
/*
 * @Description:获取指定id的员工对象
 * @author: Dario
 * @version:
 * @date: 2020/6/6 20:18
 * @param id
 * @return: com.team.domain.Employee
 */
    public Employee getEmplpyee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }

        }
        throw new TeamException("找不到指定的员工");
    }
}
