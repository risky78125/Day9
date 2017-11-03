package com.lanou3g.crm.service;

import com.lanou3g.crm.domain.Department;
import com.lanou3g.crm.domain.Post;
import com.lanou3g.crm.domain.Staff;

import java.util.List;

/**
 * Author: 武奇<p>
 * Company: lanou3g.com<p>
 * Date: 2017/11/2 <p>
 */
public interface HomeService {

    List<Department> getDepartments();

    List<Post> getPostByDeptId(int deptId);

    List<Staff> getStaffByDeptIdAndPostId(int deptId, int postId);

    List<Staff> getStaffByDeptId(int deptId);

    List<Staff> getStaffs();
}
