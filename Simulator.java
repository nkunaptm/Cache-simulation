/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author musa
 */
public class Simulator {
    public static void main(String[] args) throws FileNotFoundException {
        int hits = 0;
        int miss = 0;
        cache L1 = new cache(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        String checker;

        Scanner file = new Scanner( new FileReader(args[2]));

        while(file.hasNext()){
            checker = file.next();

            if(L1.check(checker)){
                hits++;
                //System.out.println("hit : "+checker);
            }
            else{
                miss++;
                L1.insert(checker);
                //System.out.println("miss : "+checker);
            }
        }
        System.out.println("L1 hits:    "+hits);
        System.out.println("L1 misses:  "+miss);
        System.out.println("Cycles:     "+((miss*1000)+(hits*10)));
        
    }
}
