package com.lanou3g.crm.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Author: 武奇<p>
 * Company: lanou3g.com<p>
 * Date: 2017/11/2 <p>
 */
public class HibernateUtil {

    private static final SessionFactory SF;

    static {
        try {
            SF = new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Hibernate配置文件是不是写错了呀?");
        }
    }

    public static Session openSession(){
        Session session = SF.getCurrentSession();
        // 直接开启事务
        session.beginTransaction();
        return session;
    }

    public static void commit(){
        SF.getCurrentSession()
                .getTransaction()
                .commit();
    }


}
