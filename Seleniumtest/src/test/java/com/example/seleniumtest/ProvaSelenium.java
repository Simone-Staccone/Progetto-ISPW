package com.example.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProvaSelenium{
    public static void main(String[] arg){
        ProvaSelenium p = new ProvaSelenium();
        System.out.println(p.getValue());
    }

    public int getValue(){
        int x;
        System.setProperty("webdriver.chrome.driver","src/test/java/com/example/seleniumtest/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://scholar.google.com/citations?user=PQWZTB8AAAAJ&hl=it");
        WebElement TxtBoxContent = driver.findElement(By.xpath("//*[@id=\"gsc_rsb_st\"]/tbody/tr[1]/td[2]"));

        x = Integer.parseInt(TxtBoxContent.getText());
        driver.close();

        return x;
    }
}
