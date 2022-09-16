package edu.miu.demo.aspect;

import edu.miu.demo.model.ActivityLog;
import edu.miu.demo.repo.ActivityLogRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Aspect
@Component

public class ExecutionTimeAspect {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Pointcut("@annotation(edu.miu.demo.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){}


    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Class Name: "
                + proceedingJoinPoint.getSignature().getDeclaringTypeName() +". Method Name: "
                + proceedingJoinPoint.getSignature().getName()+ ". Time taken for Execution is : " + (startTime-endTime) + "ms");
        ActivityLog activityLog = new ActivityLog(new Date(), proceedingJoinPoint.getSignature().getName(),
                startTime-endTime);
        activityLogRepo.save(activityLog);
        return object;
    }
}
