package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        int p=0;

        FileReader fr = new FileReader("pla10b.in");
        Scanner scan = new Scanner(fr);
        String s =scan.nextLine();
        int n = Integer.parseInt(s);

        ArrayList<Integer> wysokosci = new ArrayList<>();

        while(scan.hasNextLine()){
            String s1 = scan.nextLine();
            String h = s1.substring(s1.lastIndexOf(" ") + 1);
            int h1 = Integer.parseInt(h);
            wysokosci.add(h1);
        }

        ArrayDeque<Integer> stos = new ArrayDeque<>();

        try{
            for(int i=0;i<n;i++) {
                while(!stos.isEmpty() && stos.getLast() > wysokosci.get(i))
                    stos.removeLast();
                if (stos.isEmpty() || stos.getLast() < wysokosci.get(i)){
                    stos.add(wysokosci.get(i));
                    p = p+1;
                }
            }
        } catch(Exception e){}

        String nump = String.valueOf(p);
        FileWriter nFile = new FileWriter("pla.out", StandardCharsets.UTF_8);
        writeToFile(nump, nFile);
    }

    public static void writeToFile(String s, FileWriter n1File) throws Exception{
        n1File.write(s);
        n1File.close();
    }
}

