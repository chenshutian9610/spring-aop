package tree.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import tree.introduction.Cook;
import tree.introduction.CookImpl;

@Component
@Aspect
public class AspectJAdvice {
    @DeclareParents(defaultImpl = CookImpl.class,value = "tree.target.Waiter")
    public Cook cook;

    @Pointcut("execution(* tree..Waiter.*(..))")
    private void myPointcut(){}

    @Before("myPointcut()&&args(name,..)")
    public void greet(String name){
        System.out.println("waiter:hello,"+name+".");
    }

    @After("myPointcut()")
    public void answer(JoinPoint point){
        System.out.println(point.getArgs()[0]+"   :"+point.getArgs()[1]);
    }

    /* 相当于上面的 @Before + @After
    @Around("myPointcut()")
    public void around(ProceedingJoinPoint point) throws Throwable{
        System.out.println("waiter:hello,"+point.getArgs()[0]+" !");
        point.proceed();
        System.out.println(point.getArgs()[0]+"   :"+point.getArgs()[1]);
    } */
}
