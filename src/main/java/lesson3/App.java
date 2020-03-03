package lesson3;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Hello world!
 *
 */
public class App
{
    private static Logger LOG= Logger.getLogger(App.class);
    public static void main( String[] args ) {
        Pet pet=new Pet("Skubidu",5000);
        User user=new User("Ігор",28,4000);
        DOMConfigurator.configure("loggerConfig.xml");
        addUser("Marichka",25,30000);
        addPet("Richi",2500);
        buyPet(pet,user);
    }

    private static void buyPet(Pet pet,User user) {
        if(user.getNumberOfMoney()<pet.getPrice()){
            LOG.error("User tried buy pet without enought number of money");
            LOG.fatal("Fatal message");
            throw new RuntimeException("You have not enought money");
        }
    }

    private static void addPet(String nameOfPet,int price) {
        if(price<0){
            String message=String.format("Attempt adding pet with price=%d",price);
            LOG.error(message);
            throw new RuntimeException("Price can`t be less than 0");
        }else {
            Pet pet1=new Pet(nameOfPet,price);
            System.out.println(pet1);
        }
    }

    private static void addUser(String nameOfUser,int age,int numberOfMoney) {
        LOG.debug("Debug message");
        if(age<18 && age>0){
            LOG.warn("User don`t have 18 years");
        }
        LOG.info("Will be added new user with name" + nameOfUser);
        if(age<0){
            String message=String.format("Attempt adding user with age=%d",age);
            LOG.error(message);
            throw new RuntimeException("Age can`t be less than 0");
        }else {
            User user1 = new User(nameOfUser, age, numberOfMoney);
        }
    }


}
