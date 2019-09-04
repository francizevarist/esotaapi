package com.esotacredit.esotaapi.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomGenerator {

    char[] characters1 = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char[] characters2 = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    // Function select an element base on index
    // and return an element
    public char getRandomElement(char[] list)
    {
        Random rand = new Random();
        return list[rand.nextInt(list.length)];
    }

    // and return an element
    public String getRandomElement(String[] list)
    {
        Random rand = new Random();
        return list[rand.nextInt(list.length)];
    }

    public int getRandomDigits(){
        int min = 1000;
        int max = 9999;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public int getRandomDigitsExtended(){
        int min = 100000;
        int max = 999900;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public char getRandomCharacters1(){
        return getRandomElement(characters1);
    }
    public char getRandomCharacters2(){
        return getRandomElement(characters2);
    }

    @GetMapping("/referencenumber")
    public String getSessionNumberLink(){
        return String.valueOf(getRandomCharacters1())+String.valueOf(getRandomCharacters1())+String.valueOf(getRandomDigits());
    }

    public String getReferenceNumber(){
        return String.valueOf(getRandomCharacters1())+String.valueOf(getRandomCharacters2())+String.valueOf(getRandomDigits());
    }

    public String getVerificationCode(){
        return String.valueOf(String.valueOf(getRandomDigitsExtended()));
    }

}
