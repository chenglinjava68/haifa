package org.wrj.haifa.dubbo.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wrj.haifa.dubbo.api.DubboConstant;
import org.wrj.haifa.dubbo.api.TimeService;

import java.sql.Timestamp;

/**
 * Created by wangrenjun on 2018/4/19.
 */
public class DubboConsumerWithContext {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring-dubbo-consumer.xml"});
        context.start();
        // obtain proxy object for remote invocation
        TimeService timeService = (TimeService) context.getBean("timeService");
        // execute remote invocation

        RpcContext.getContext().getAttachments().put(DubboConstant.DUBBO_CLIENT_THREAD_NAME,"dubbo-consumer-"+Thread.currentThread().getName());

       timeService.invokeWithContxtInfo();
        // show the result
        //System.out.println(time);

    }
}
