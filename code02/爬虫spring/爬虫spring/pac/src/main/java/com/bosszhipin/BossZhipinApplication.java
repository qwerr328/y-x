package com.bosszhipin;

import com.bosszhipin.crawler.BossZhipinCrawler;

public class BossZhipinApplication {
    public static void main(String[] args) {
        new BossZhipinCrawler().crawl();
    }
}