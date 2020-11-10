package com.commons.utils.aop;

import com.commons.utils.constants.LevelLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class HandlerCommonAspect {

   @Pointcut("execution( * com.microservicios.*.controllers.*.*(..))")
   public void pointCutMethod() {
   }

   @Before("pointCutMethod()")
   public void before(JoinPoint point) {
      String[] rootPackage = point.getTarget().getClass().getName().split("\\.");
      String microservicio = rootPackage[2].toString();/* » com.microservicios.test.controllers.TestController */
      String entity = rootPackage[2].toString().toUpperCase();/* » com.microservicios.test.controllers.TestController */
      System.setProperty("microservicio", microservicio);
      System.setProperty("entity", entity);
      System.setProperty("method", point.getSignature().getName());
      System.setProperty("levelLog", LevelLog.ERROR);/* » Default level-log... */
   }
}