package automation;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutomationFirstProject {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/baigalmisheel/Desktop/selenium /chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(500);

        // 1. Navigate to http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php
        driver.navigate().to("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

        //2. Verify the the title is "Welcome to Duotify!"

        String actualTitle = driver.getTitle();
        driver.manage().window().maximize();
        String expectedTitle = "Welcome to Duotify!";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title matched");
        } else {
            System.out.println("Title didn't match");
        }

        //3. Click on Signup here

        Thread.sleep(500);
        driver.findElement(By.className("hasAccountText")).click();


        // 4. Fill out the form with the required info
        //5. Click on Sign up

        Thread.sleep(500);

        driver.findElement(By.name("username")).sendKeys("Naaraa56");
        driver.findElement(By.name("firstName")).sendKeys("Misheel");
        driver.findElement(By.name("lastName")).sendKeys("Bold");
        driver.findElement(By.name("email")).sendKeys("zula56Duotech@gmail.com");
        driver.findElement(By.name("email2")).sendKeys("zula56Duotech@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Sara12345");
        driver.findElement(By.name("password2")).sendKeys("Sara12345", Keys.ENTER);

        Thread.sleep(500);

        if (driver.getPageSource().contains("You Might Also Like")) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");

        }
        //6. Once logged in to the application, verify that the URL is:

        Thread.sleep(500);
        String expectedURL="http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        String actualURL= driver.getCurrentUrl();

        Thread.sleep(500);
        if (expectedURL.equals(actualURL)) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //7. In the left navigation bar, verify that your first and
        // last name matches the first and last name that you used when signing up.

        Thread.sleep(500);

        driver.findElement(By.id("nameFirstAndLast")).getText();

        //This is the String I want to find
        String expectedFirstAndLast="Misheel Bold";

        //If there are these symbols associated with the name-show invalid
        String patternString = ".*$%^#:.*";

        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expectedFirstAndLast);

        Thread.sleep(500);

        if(matcher.find()){

            System.out.println("Invalid Name" );
        }
        else{
            System.out.println("Valid Name");
        }


        //8. Click on the username on the left navigation bar and verify
        // the username on the main window is correct and then click logout.

        Thread.sleep(500);
        driver.findElement(By.id("nameFirstAndLast")).click();

        // driver.findElement(By.class("userInfo")).getText();

        Thread.sleep(500);
        driver.findElement(By.id("rafael")).click();

        //9. Verify that you are logged out by verifying the URL is:
        //http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php

        Thread.sleep(500);
        String expectedSecondURL="http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php";
        String actualSecondURL= driver.getCurrentUrl();

        if (expectedSecondURL.equals(actualSecondURL)) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //10. Login using the same username and password when you signed up.

        driver.findElement(By.name("loginUsername")).sendKeys("Naaraa56");
        driver.findElement(By.name("loginPassword")).sendKeys("Sara12345", Keys.ENTER);

        Thread.sleep(500);

        //11. Verify successful login by verifying that the home page contains the text "You Might Also Like".

        if (driver.getPageSource().contains("You Might Also Like")) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");

        }

        driver.quit();
    }}
