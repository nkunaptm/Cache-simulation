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
public class Simulator2 {
    public static void main(String[] args) throws FileNotFoundException {
        int hits1 = 0;
        int miss1 = 0;
        int hits2 = 0;
        int miss2 = 0;
        cache L1 = new cache(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        cache L2 = new cache(Integer.parseInt(args[2]),Integer.parseInt(args[3]));
        String checker;

        Scanner file = new Scanner( new FileReader(args[4]));

        while(file.hasNext()){
            checker = file.next();

            if(L1.check(checker)){
                hits1++;
                //System.out.println("hit : "+checker);
            }
            else if(L2.check(checker)){
                miss1++;
                L1.insert(checker);
                hits2++;
                //System.out.println("miss : "+checker);
            }
            else{
                miss1++;
                miss2++;
                L1.insert(checker);
                L2.insert(checker);
            }
        }
        System.out.println("L1 hits:    "+hits1);
        System.out.println("L1 misses:  "+miss1);
        System.out.println("L2 hits:    "+hits2);
        System.out.println("L2 misses:  "+miss2);
        System.out.println("Cycles:     "+((miss2*1000)+(hits2*100)+(hits1*10)));
    }

}
