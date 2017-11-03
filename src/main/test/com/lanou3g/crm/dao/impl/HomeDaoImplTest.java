package com.lanou3g.crm.dao.impl;

import com.lanou3g.crm.dao.HomeDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: 武奇<p>
 * Company: lanou3g.com<p>
 * Date: 2017/11/2 <p>
 */
public class HomeDaoImplTest {

    private HomeDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new HomeDaoImpl();
    }

    @Test
    public void getDepartmentsTest() throws Exception {
        Assert.assertEquals(dao.getDepartments().size(), 2);
    }

    @Test
    public void getPostByDeptIdTest() throws Exception {
        Assert.assertEquals(dao.getPostByDeptId(1).size(), 3);
    }

    @Test
    public void getStaffByDeptIdAndPostIdTest() throws Exception {
        Assert.assertEquals(dao.getStaffByDeptIdAndPostId(2, 5).size(), 2);
    }

    @Test
    public void getStaffByDeptIdTest() throws Exception {
        Assert.assertEquals(dao.getStaffByDeptId(1).size(), 5);
    }

    @Test
    public void getStaffsTest() throws Exception {
        Assert.assertEquals(dao.getStaffs().size(), 8);
    }

}