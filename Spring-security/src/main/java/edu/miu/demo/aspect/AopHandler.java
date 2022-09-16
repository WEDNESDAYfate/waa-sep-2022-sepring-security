package edu.miu.demo.aspect;

import edu.miu.demo.aspect.exception.AopIsAweSomeHeaderException;
import edu.miu.demo.model.ActivityLog;
import edu.miu.demo.repo.ActivityLogRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Aspect
@Component
public class AopHandler {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Pointcut("within(edu.miu.demo.service..*)")
    public void logAnyFunctionWithinResource() {}

    @Around("logAnyFunctionWithinResource()")
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

    @Before("logAnyFunctionWithinResource()")
    public void logBefore(JoinPoint joinPoint) throws AopIsAweSomeHeaderException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
        if (request.getMethod().contentEquals("POST")) {
            var header = request.getHeader("AOP");
            if (header == "AOP-IS-AWESOME") {
                log.info(header);
            } else if (header == null) {
                AopIsAweSomeHeaderException AopIsAweSomeHeaderException = new AopIsAweSomeHeaderException("Header not included!");
                throw AopIsAweSomeHeaderException;
            }
        }
    }
}
