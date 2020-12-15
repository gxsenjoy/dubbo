package com.alibaba.dubbo.demo.consumer;

import com.alibaba.dubbo.config.spring.ServiceBean;
import com.alibaba.dubbo.demo.DemoService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        final  ConfigurableListableBeanFactory  finalbeanFactory = beanFactory;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(((DemoService)finalbeanFactory.getBean("demoService")).sayHello("AAAAA"));
                }

            }
        }).start();


    }
}
