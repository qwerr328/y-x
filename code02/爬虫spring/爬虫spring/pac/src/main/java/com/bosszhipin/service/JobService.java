package com.bosszhipin.service;

import com.bosszhipin.entity.Job;
import com.bosszhipin.mapper.JobMapper;
import org.apache.ibatis.session.SqlSession; // 导入 MyBatis 原生 SqlSession
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JobService {
    private static final SqlSessionTemplate sqlSessionTemplate;

    static {
        // 加载 Spring 配置文件（需确保文件存在）
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-datasource.xml");
        sqlSessionTemplate = context.getBean(SqlSessionTemplate.class);
    }

    public void saveJob(Job job) {
        // 使用 SqlSessionTemplate 获取 Mapper，无需手动开启会话
        JobMapper mapper = sqlSessionTemplate.getMapper(JobMapper.class); // 直接通过模板获取 Mapper
        mapper.save(job);
        // 若无需手动事务，无需调用 commit()，SqlSessionTemplate 会自动处理
    }
}