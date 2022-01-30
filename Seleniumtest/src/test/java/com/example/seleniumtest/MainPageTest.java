package com.example.seleniumtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class MainPageTest {
    @Test
    public void TestProvaSelenium(){
        ProvaSelenium p = new ProvaSelenium();
        int value = p.getValue();
        int output = 1800;
        if(value > 1800)
        {
           output = value;
        }
        assertEquals(output,value,0);
    }
}
