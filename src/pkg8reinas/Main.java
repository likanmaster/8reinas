package pkg8reinas;
import java.util.*;
import java.io.*;
import java.math.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author likanmaster
 */
public class Main {
Scanner sc = new Scanner(System.in);   

    /**
     * @param args the command line arguments
     */
    public void randomceroyuno() {//funcion para generar un numer random  entre 0 y 1
    
            
        int tablero =(int)(Math.random());
        System.out.println(tablero); 
    }

   
    public static void main(String[] args) {
        // TODO code application logic here
        int[] tablero = new int[8];
        for (int i=0;i<8;i++){//poblaciones
            for (int j=0;j<8;j++){
                  tablero[i] =(int)(Math.random()*10);
                  System.out.print(" ");
                  System.out.print(tablero[i]);
             }
             System.out.println();
        }
    }
   
    
}
