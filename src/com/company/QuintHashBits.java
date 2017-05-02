package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by casters on 4/26/17.
 */
public class QuintHashBits {
    List<Boolean> filter = null;
    int size;
    public int hash1(String input){
        int toRet = 0;
        int tmp = 0;
        int radix = 1;
        for(int a = 0; a<input.length(); a++){
            tmp = (int)input.charAt(a);
            tmp = tmp * radix;
            toRet+=tmp;
            radix = radix*10;
        }
        toRet = toRet * size;
        toRet = toRet/7;
        toRet = toRet%size;
        if(toRet<0) toRet = -toRet;
        return toRet;
    }
    public int hash2(String input){
        int toRet = 0;
        int tmp = 0;
        int radix = 1;
        for(int a = 0; a<input.length(); a++){
            tmp = (int)input.charAt(a);
            tmp = tmp * radix;
            toRet+=tmp;
            radix = radix*10;
        }
        toRet = toRet*size;
        toRet = toRet*3;
        toRet = toRet/4;
        toRet = toRet%size;
        if(toRet<0) toRet = -toRet;
        return toRet;

    }
    public int hash3(String input){
        int toRet = 0;
        int tmp = 0;
        int radix = 1;
        for(int a = input.length()-1; 0<=a; a--){
            tmp = (int)input.charAt(a);
            tmp = tmp * radix;
            toRet+=tmp;
            radix = radix*10;
        }
        toRet = toRet *size;
        toRet = toRet / 6;
        toRet = toRet *5;
        toRet = toRet%size;
        if(toRet<0) toRet = -toRet;
        return toRet;
    }
    public int hash4(String input){
        int toRet = 0;
        int tmp = 0;
        int radix = 1;
        for(int a = input.length()-1; 0<=a; a--){
            tmp = (int)input.charAt(a);
            tmp = tmp * radix;
            toRet+=tmp;
            radix = radix*10;
        }
        toRet = toRet*size;
        toRet = toRet *3;
        toRet = toRet/7;
        toRet = toRet%size;
        if(toRet<0) toRet = -toRet;
        return toRet;
    }
    public int hash5(String input){
        int toRet = 0;
        int tmp = 0;
        int radix = 1;
        for(int a = input.length()-1; 0<=a; a--){
            tmp = (int)input.charAt(a);
            tmp = tmp * radix;
            toRet+=tmp;
            radix = radix*10;
        }
        toRet = toRet*size;
        toRet = toRet/5;
        toRet = toRet+314159;
        toRet = toRet*2;
        toRet = toRet%size;
        if(toRet<0) toRet = -toRet;
        //System.out.println("input: " + input + " hash5: " + toRet);
        return toRet;
    }
    public boolean inQuint(String input){
        int h1, h2, h3, h4, h5;
        h1 = hash1(input);
        h2 = hash2(input);
        h3 = hash3(input);
        h4 = hash4(input);
        h5 = hash5(input);
        if(filter.get(h1)) return true;
        if(filter.get(h2)) return true;
        if(filter.get(h3)) return true;
        if(filter.get(h4)) return true;
        if(filter.get(h5)) return true;
        return false;
    }
    public QuintHashBits(String input) throws IOException{
        int h1, h2, h3, h4, h5;
        char tmpChar;
        int dictSize;
        String tmpWord = "";
        int tmpInt = 0;
        FileReader inf = null;
        File dictFP = new File(input);
        inf = new FileReader(input);
        dictSize = (int)dictFP.length();
        size = 10*dictSize;
        filter = new ArrayList<Boolean>(size);
        for(int a = 0; a<size; a++){
            filter.add(a, false);
        }
        for(long i = 0; i<dictSize; i++){
            while((tmpInt = (int)inf.read()) != -1){
                tmpChar = (char)tmpInt;
                if(tmpChar=='\n') break;
                tmpWord += tmpChar;
                i++;
            }
            if(tmpInt==-1) break;
            //System.out.println(tmpWord);
            h1 = hash1(tmpWord);
            h2 = hash2(tmpWord);
            h3 = hash3(tmpWord);
            h4 = hash4(tmpWord);
            h5 = hash5(tmpWord);
            filter.set(h1, true);
            filter.set(h2, true);
            filter.set(h3, true);
            filter.set(h4, true);
            filter.set(h5, true);
            tmpWord = "";
        }
        inf.close();
    }
}
