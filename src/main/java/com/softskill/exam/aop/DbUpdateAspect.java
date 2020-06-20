package com.softskill.exam.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 该切面用于在DB Update(更新)操作时设置cUpdateTime字段值
 */
@Aspect
@Component
public class DbUpdateAspect {

    private Logger logger = LoggerFactory.getLogger(DbUpdateAspect.class);

    @Pointcut("execution(public * com.softskill.exam.dao.*.update*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
         Object[] args = joinPoint.getArgs();
         Object obj = null;
         if(args.length>0){
             obj = args[0];
         }
         getObj(obj,new Date());
    }

    private <T> T getObj(T t, Date date) throws Exception {
        Class clazz = t.getClass();
        clazz.getDeclaredMethod("setcUpdateTime", Date.class).invoke(t, date);
        return t;
    }

}
