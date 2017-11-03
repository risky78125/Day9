package com.lanou3g.crm.utils;

import com.lanou3g.crm.domain.Department;
import com.lanou3g.crm.domain.Post;
import com.lanou3g.crm.domain.Staff;
import org.junit.Test;

import java.util.List;

/**
 * Author: 武奇<p>
 * Company: lanou3g.com<p>
 * Date: 2017/11/2 <p>
 */
public class QueryUtilTest {

    @Test
    public void queryTest(){
        System.out.println(QueryUtil.findAll(Department.class));
        System.out.println(QueryUtil.findAll(Post.class));
        System.out.println(QueryUtil.findAll(Staff.class));
    }

    @Test
    public void queryTest2(){
        // 查询部门id为1的所有员工
        List<Staff> list1 = QueryUtil.queryByEqual(Staff.class, "gender", "女");
        System.out.println(list1);
    }

    @Test
    public void queryTest3(){
        // 多条件查询
        // 查询教学部的所有男员工
        //
        String[] fields = {"dept", "gender"};
        Object[] values = {1, "女"};

        List<Staff> staffs = QueryUtil.queryByEquals(Staff.class, fields, values);
        System.out.println(staffs);
    }

}