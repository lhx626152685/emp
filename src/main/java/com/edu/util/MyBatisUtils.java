package com.edu.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {

    public static final boolean DEFAULT_AUTO_COMMIT = true;

    private static final SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
            MyBatisUtils.class.getClassLoader().getResourceAsStream("mybatis.xml")
    );

    private static SqlSession getSqlSession (boolean autoCommit) {
        return factory.openSession(autoCommit);
    }

    public static SqlSession getSqlSession(){
        return factory.openSession(DEFAULT_AUTO_COMMIT);
    }

}
