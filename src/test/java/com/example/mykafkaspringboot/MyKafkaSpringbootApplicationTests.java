package com.example.mykafkaspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyKafkaSpringbootApplicationTests {

    /**
     * 生产者demo
     */

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void test1() {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("t3", "user00211", "xh211");
        // 异步处理的结果对象
//        future.addCallback(
//                new SuccessCallback<SendResult<String, String>>() {
//                    @Override
//                    public void onSuccess(SendResult<String, String> result) {
//                        System.out.println("发送成功！");
//                    }
//                },
//                new FailureCallback() {
//                    @Override
//                    public void onFailure(Throwable ex) {
//                        System.out.println("发送失败！");
//                        ex.printStackTrace();
//                    }
//                }
//        );
        future.addCallback(
                obj -> {
                    System.out.println("发送成功！");
                },
                t -> {
                    System.out.println("发送失败！");
                    t.printStackTrace();
                });
    }

}
