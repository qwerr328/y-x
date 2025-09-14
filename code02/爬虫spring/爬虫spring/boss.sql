CREATE DATABASE IF NOT EXISTS bosszhipin 
DEFAULT CHARSET utf8mb4 
COLLATE utf8mb4_unicode_ci;

USE bosszhipin;

CREATE TABLE job (
  id INT AUTO_INCREMENT PRIMARY KEY,
  job_name VARCHAR(200) NOT NULL COMMENT '职位名称',
  salary VARCHAR(50) COMMENT '薪资',
  company_name VARCHAR(200) NOT NULL COMMENT '公司名称',
  company_type VARCHAR(100) COMMENT '公司类型',
  city VARCHAR(50) COMMENT '工作地点',
  experience VARCHAR(50) COMMENT '经验要求',
  education VARCHAR(50) COMMENT '学历要求',
  description TEXT COMMENT '职位描述',
  url VARCHAR(300) UNIQUE NOT NULL COMMENT '职位链接',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '抓取时间'
);