package com.lanou3g.crm.service.impl;

import com.lanou3g.crm.dao.HomeDao;
import com.lanou3g.crm.dao.impl.HomeDaoImpl;
import com.lanou3g.crm.domain.Department;
import com.lanou3g.crm.domain.Post;
import com.lanou3g.crm.domain.Staff;
import com.lanou3g.crm.service.HomeService;

import java.util.List;

/**
 * Author: 武奇<p>
 * Company: lanou3g.com<p>
 * Date: 2017/11/2 <p>
 */
public class HomeServiceImpl implements HomeService{

    private HomeDao dao;

    public HomeServiceImpl() {
        dao = new HomeDaoImpl();
    }

    @Override
    public List<Department> getDepartments() {
        return dao.getDepartments();
    }

    @Override
    public List<Post> getPostByDeptId(int deptId) {
        return dao.getPostByDeptId(deptId);
    }

    @Override
    public List<Staff> getStaffByDeptIdAndPostId(int deptId, int postId) {
        if (deptId < 1){
            return dao.getStaffs();
        }else if (postId < 1){
            return dao.getStaffByDeptId(deptId);
        }
        return dao.getStaffByDeptIdAndPostId(deptId, postId);
    }

    @Override
    public List<Staff> getStaffByDeptId(int deptId) {
        if (deptId < 1){
            return dao.getStaffs();
        }
        return dao.getStaffByDeptId(deptId);
    }

    @Override
    public List<Staff> getStaffs() {
        return dao.getStaffs();
    }
}
