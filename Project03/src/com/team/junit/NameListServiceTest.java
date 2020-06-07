package com.team.junit;

import com.team.domain.Employee;
import com.team.service.NameListService;
import com.team.service.TeamException;
import org.junit.Test;

/*
 * @Description: 对NameListService类的测试
 * @author: Dario
 * @version:
 * @date: 2020/6/6 21:03
 * @param null
 * @return:
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id = 1;
        try {
            Employee employee = service.getEmplpyee(1);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }
    }
}
