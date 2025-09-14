package com.bosszhipin.crawler;

import com.bosszhipin.entity.Job;
import com.bosszhipin.service.JobService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BossZhipinCrawler {
    private static final String BASE_URL = "https://www.zhipin.com/beijing/";
    private static final JobService jobService = new JobService();

    public void crawl() {
        try {
            // 模拟浏览器请求头
            Document doc = Jsoup.connect(BASE_URL)
                    .userAgent(
                            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
                    .get();

            // 解析职位列表（以首页精选职位为例）
            Elements jobElements = doc.select(".job-info");
            for (Element jobElement : jobElements) {
                Job job = parseJob(jobElement);
                jobService.saveJob(job);
                System.out.println("已抓取：" + job.getJobName());
            }

            // 解析热门企业职位（可选）
            Elements companyElements = doc.select(".company-job-item");
            for (Element companyElement : companyElements) {
                Job job = parseCompanyJob(companyElement);
                jobService.saveJob(job);
                System.out.println("已抓取：" + job.getJobName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Job parseJob(Element element) {
        Job job = new Job();
        job.setJobName(element.select(".name").text());
        job.setSalary(element.select(".salary").text());
        job.setUrl(element.attr("href"));

        // 解析公司名称
        Element companyElement = element.parents().select(".company-info .name").first();
        if (companyElement != null) {
            job.setCompanyName(companyElement.text());
        } else {
            job.setCompanyName("未知公司");
        }

        // 解析工作地点、经验、学历（需根据实际HTML结构调整选择器）
        Elements tags = element.select(".job-text span");
        if (tags.size() >= 3) {
            job.setCity(tags.get(0).text());
            job.setExperience(tags.get(1).text());
            job.setEducation(tags.get(2).text());
        }
        return job;
    }

    private Job parseCompanyJob(Element element) {
        Job job = new Job();
        job.setJobName(element.select(".job-info-top .name").text());
        job.setSalary(element.select(".job-info-top .salary").text());
        job.setUrl(element.attr("href"));

        // 解析公司名称（从父级元素获取）
        Element companyNameElement = element.parents().select(".company-info h3").first();
        if (companyNameElement != null) {
            job.setCompanyName(companyNameElement.text());
        } else {
            job.setCompanyName("未知公司");
        }

        return job;
    }

    public static void main(String[] args) {
        new BossZhipinCrawler().crawl();
    }
}