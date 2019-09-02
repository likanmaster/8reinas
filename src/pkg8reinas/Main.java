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
    public void randomceroyuno(){//funcion para generar un numer random  entre 0 y 1
    
            
        int tablero =(int)(Math.random());
        System.out.println(tablero); 
    }

    public void randomunoyn(){//funcion para generar un numer random  entre 1 y n
        
        int tablero =(int)(Math.random());
        System.out.println(tablero); 
    } 
    
     public void calcularfittnes(){//funcion para calcular el fittnes de cada individuo
         for (int i=0;i<10;i++){//cantidad de  tableros
            for (int j=0;j<8;j++){
           
            
            }
         }     
    } 
    public static void main(String[] args) {
        // TODO code application logic here
        int semilla=8;
        int tpoblacion=100;
        int pcruza=10;
        int pmutaccion=10;
        int iteraciones=10;
        int[] tablero = new int[8];//tablero de 8
        
        for (int i=0;i<tpoblacion;i++){//cantidad de  tableros
            for (int j=0;j<8;j++){
                  tablero[j] =(int)(Math.random()*10);
                  System.out.print(" ");
                  System.out.print(tablero[j]);
             }
             System.out.println();
        }
    }
   
    
}
