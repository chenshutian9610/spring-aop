package tree;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import tree.introduction.Cook;
import tree.introduction.CookImpl;
import tree.target.Waiter;

public class Main {
    @Test
    public void doInTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        Waiter waiter=context.getBean(Waiter.class);
        waiter.question("Tom","coffee");
        ((Cook)waiter).make();
    }
}
