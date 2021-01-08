package dev.gwozdz.SpringBeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class LifeCycleBeanDemo implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    private int counter =0;

    //Constructor first
    public LifeCycleBeanDemo() {
        System.out.println(counter++ + ". Im in the LifeCycleBean constructor.");
    }
    //BeanNameAware interface & setBeanName()
    @Override
    public void setBeanName(String s) {
        System.out.println(counter++ +". Bean name has been set to: " + s);
    }

    //BeanFactoryAware interface & setBeanFactory()
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(counter++ +". Bean Factory has been set.");
    }

    //ApplicationContextAware interface & setApplicationContext()
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(counter++ +". Application context has been set.");
    }

    //BeanPostProcessor called postProcessorBeforeInitialization()
    public void beforeInit(){
        System.out.println(counter++ +". Before init - called by Bean Post Processor.");
    }


    //Method annotated @PostConstruct called postConstruct()
    @PostConstruct
    public void postConstruct(){
        System.out.println(counter++ +". The post construct annotated method has been called.");
    }

    //InitializingBean interface & afterPropertiesSet()
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(counter++ +". The LifeCycleBean has its properties set.");
    }

    //BeanPostProcessor called postProcessorAfterInitialization()
    public void  afterInit(){
        System.out.println(counter++ +". After init - called by Bean Post Processor.");
    }

    //Method annotated @PreDestroy called preDestroy()
    @PreDestroy
    public void preDestroy(){
        System.out.println(counter++ +". The pre destroy annotated method has been called.");
    }

    //DisposableBean interface with destroy()
    @Override
    public void destroy() throws Exception {
        System.out.println(counter++ +". The LifeCycleBean has been terminated.");
    }




}
