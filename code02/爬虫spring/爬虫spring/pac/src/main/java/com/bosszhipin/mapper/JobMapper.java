package com.bosszhipin.mapper;

import com.bosszhipin.entity.Job;
import org.apache.ibatis.annotations.Insert;

public interface JobMapper {
    @Insert("INSERT INTO job (" +
            "job_name, salary, company_name, company_type, city, experience, education, description, url) " +
            "VALUES (#{jobName}, #{salary}, #{companyName}, #{companyType}, #{city}, #{experience}, #{education}, #{description}, #{url}) " +
            "ON DUPLICATE KEY UPDATE salary=VALUES(salary), description=VALUES(description)")
    int save(Job job);
}