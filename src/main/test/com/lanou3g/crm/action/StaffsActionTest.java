package com.lanou3g.crm.action;

import com.lanou3g.crm.domain.Staff;
import com.lanou3g.crm.service.HomeService;
import com.lanou3g.crm.service.impl.HomeServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Author: 武奇<p>
 * Company: lanou3g.com<p>
 * Date: 2017/11/3 <p>
 */
public class StaffsActionTest {

    @Test
    public void testQuery(){
        HomeService service = new HomeServiceImpl();
        List<Staff> staffs = service.getStaffByDeptIdAndPostId(1, 3);
        for (Staff staff : staffs) {
            System.out.println(staff.getDept().getName());
            System.out.println(staff.getPost().getName());
        }
    }

}