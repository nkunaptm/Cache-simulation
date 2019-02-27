/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
/**
 *
 * @author musa
 */
public class cache {
    int block;
    int Tblocks;
    int offset;
    String[][] cacheline;
    int line;
    int bytesPblock;

    cache(int blocks, int BperB){
        Tblocks = blocks;
        cacheline = new String [blocks][BperB/2];
        line = BperB/2;
        bytesPblock = BperB;

    }

    public boolean check(String addr){
        String binAddr = Integer.toBinaryString(Integer.parseInt(addr , 16));
        while(binAddr.length()<16){
            binAddr = '0' +binAddr;
        }
        int holder = (16-logC(bytesPblock)-(logC(Tblocks)+1));

        //System.out.println(holder);

        block = Integer.parseInt(binAddr.substring(holder, 16-logC(bytesPblock)),2);
        offset = Integer.parseInt(binAddr.substring(16-logC(bytesPblock)),2);

        if(cacheline[block][offset]!=null){
            if(cacheline[block][offset].equals(addr)){
                return true;
            }
            else{return false;}
        }
        return false;
    }

    public void insert(String addr){

        String binAddr = Integer.toBinaryString(Integer.parseInt(addr , 16));
        while(binAddr.length()<16){
            binAddr = '0' +binAddr;
        }

        String holder = "";
        for (int i = 0; i < logC(bytesPblock); i++) {
            holder = holder + "0";
        }

        int start = Integer.parseInt(binAddr.substring(0,16-logC(bytesPblock))+holder,2);

        for (int i = 0; i < line; i++) {
            cacheline[block][i] = Integer.toHexString(start);
            start++;
        }
    }

    public int logC(int x){
        int y = x;
        int count = 0;
        while(y!=2){
            y = y/2;
            count++;
        }
        return count;
    }

    public void tostring(){
      System.out.println("cache contains:");
      for (int i = 0; i < line; i++) {
        System.out.println(Arrays.deepToString(cacheline[i]));
      }
    }
}
