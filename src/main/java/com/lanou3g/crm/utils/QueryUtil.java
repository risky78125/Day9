package com.lanou3g.crm.utils;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Author: 武奇<p>
 * Company: lanou3g.com<p>
 * Date: 2017/11/2 <p>
 */
public class QueryUtil {

    public static <T> List<T> findAll(Class<T> clazz){
        return queryByEquals(clazz, null, null);
    }

    public static <T> List<T> queryByEqual(Class<T> clazz, String fieldName, Object value){
        String[] fields = {fieldName};
        Object[] values = {value};
        return queryByEquals(clazz, fields, values);
    }

    public static <T> List<T> queryByEquals(Class<T> clazz, String[] fieldNames, Object[] values){
        Session session = HibernateUtil.openSession();
        // 查询
        CriteriaBuilder builder = session.getCriteriaBuilder();
        // 后面填入的Class类型, 代表最终需要查询的结果类型
        CriteriaQuery<T> query = builder.createQuery(clazz);
        // 这个Class代表要查询的表
        Root<T> root = query.from(clazz);
        // 构建查询语句
        query.select(root);
        // 循环添加查询条件
        if (fieldNames == null || values == null || fieldNames.length != values.length){
            // 进行数据合法性验证
            // 此时数据不合法
        }else{
            Predicate[] pres = new Predicate[fieldNames.length];
            for (int i = 0; i < fieldNames.length; i++) {
                pres[i] = builder.equal(root.get(fieldNames[i]), values[i]);
            }
            query.where(pres);
        }
        Query<T> tQuery = session.createQuery(query);
        // 获取查询的结果
        List<T> list = tQuery.list();
        // 提交事务
        HibernateUtil.commit();
        return list;
    }

}
