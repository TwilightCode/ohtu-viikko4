package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        VaaraSalasana(driver);
        EiOlemassaOlevaaKayttajaa(driver);
        uudenKauttajanLuonti(driver);
        uudenKauttajanLuontiJaPoistuminen(driver);
    }
    
    public static void VaaraSalasana(WebDriver driver){
        driver.get("http://localhost:8090");
        System.out.println("VaaraSalasanaTesti=========================");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));
        element.click(); 
        
         System.out.println("==");
        
        System.out.println( driver.getPageSource() );
         element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkel");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
    } 
    
    public static void EiOlemassaOlevaaKayttajaa(WebDriver driver){
        driver.get("http://localhost:8090");
        System.out.println("EiOlemassaOlevaaKayttajaaTesti========================");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));
        element.click(); 
        
         System.out.println("==");
        
        System.out.println( driver.getPageSource() );
         element = driver.findElement(By.name("username"));
        element.sendKeys("manu");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkel");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
    } 
    
    public static void uudenKauttajanLuonti(WebDriver driver){
        driver.get("http://localhost:8090");
        System.out.println("uudenKauttajanLuontiTesti====================");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click(); 
        
         System.out.println("==");
        
        System.out.println( driver.getPageSource() );
         element = driver.findElement(By.name("username"));
        element.sendKeys("uusin");
        element = driver.findElement(By.name("password"));
        element.sendKeys("uus1ks1n");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("uus1ks1n");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
    } 
    
     public static void uudenKauttajanLuontiJaPoistuminen(WebDriver driver){
        driver.get("http://localhost:8090");
        System.out.println("uudenKauttajanLuontiJaPoistuminenTesti====================");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click(); 
         System.out.println("==");
        
        System.out.println( driver.getPageSource() );
         element = driver.findElement(By.name("username"));
        element.sendKeys("uusinmak");
        element = driver.findElement(By.name("password"));
        element.sendKeys("uus1ks1nr");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("uus1ks1nr");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click(); 
         System.out.println("==");
        System.out.println( driver.getPageSource() );
          element = driver.findElement(By.linkText("logout"));
        element.click();
           System.out.println("==");
        System.out.println( driver.getPageSource() );
    } 
}