package com.findmoreplus.xxljob.jobHandler;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class HelloJobHandler {


    @XxlJob("helloJobHandler")
    public void Hello() {
        System.out.println(new Date() + "xxl-job hello world");
        log.info("1111111111111111111111111111111111");
    }
}
