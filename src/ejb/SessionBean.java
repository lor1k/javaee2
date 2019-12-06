package ejb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class SessionBean {
    public SessionBean() {
    }
    public void writeToConsole(String s){
        System.out.println(s);
    }
    public void doTask1(){
        writeToConsole("Task1");
        doTask2();
    }

    @Asynchronous
    public void doTask2(){
        writeToConsole("Task2");
    }
}
