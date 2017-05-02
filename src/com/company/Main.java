package com.company;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        String tripHashOut = "";
        String quintHashOut = "";
        FileReader toCheck = null;
        File checkFP = new File((args[3]));
        toCheck = new FileReader(args[3]);
        int inLen = (int)checkFP.length();
        char tmpChar;
        String tmpWord = "";
        int tmpInt = 0;


        TripHashBits tripFil= new TripHashBits(args[1]);
        QuintHashBits quintFil = new QuintHashBits(args[1]);
        int size = quintFil.size;


        while(toCheck.read()!='\n');

        for(int i = 0; i<inLen; i++){
            while((tmpInt = (int)toCheck.read()) != -1){
                tmpChar = (char)tmpInt;
                if(tmpChar=='\n') break;
                tmpWord += tmpChar;
                i++;
            }
            if(tmpInt==-1) break;

            if(tripFil.inTrip(tmpWord)){
                tripHashOut += "maybe\n";
            } else {
                tripHashOut+= "no\n";
            }
            if(quintFil.inQuint(tmpWord)){
                quintHashOut+= "maybe\n";
            } else {
                quintHashOut+= "no\n";
            }
            tmpWord = "";
        }
        PrintWriter writer = new PrintWriter(args[5], "UTF-8");
        writer.println(tripHashOut);
        writer.close();
        PrintWriter writer2 = new PrintWriter(args[6], "UTF-8");
        writer2.println(quintHashOut);
        writer2.close();
    }
}
