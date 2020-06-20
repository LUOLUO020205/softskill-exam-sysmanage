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
 * 该切面用于在DB Save(新增)操作时设置cCreateTime和cUpdateTime两个字段值
 * String methodName = joinPoint.getSignature().getName(); 可以获取到方法名，故可以将两个切面类整合成一个。
 */
@Aspect
@Component
public class DbSaveAspect {

    private Logger logger = LoggerFactory.getLogger(DbSaveAspect.class);

    @Pointcut("execution(public * com.softskill.exam.dao.*.insert*(..))")
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
        clazz.getDeclaredMethod("setcCreateTime", Date.class).invoke(t, date);
        clazz.getDeclaredMethod("setcUpdateTime", Date.class).invoke(t, date);
        return t;
    }

}
