/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import javax.swing.JOptionPane;

/**
 *
 * @author VICTOR SERRANO
 */
public class CongruencialMixto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Seleccion de a
        double a = -1;
        int k = 0;
        while (a < 0) {
            k = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de k", "a = 1 + 2^k", JOptionPane.QUESTION_MESSAGE));
            a = Math.pow(2, k) + 1;
        }
        //Seleccion de x
        int x = -1;
        while (x < 0) {
            x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de x"));
        }
        //Seleccion de m
        double m = 0;
        int d = 0;
        while (m <= 0 || m < a || m < x) {
            d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de d", "m= p^d", JOptionPane.QUESTION_MESSAGE));
            m = Math.pow(2, d);
        }
        //Seleccion de c
        double c = primo_Cercano(m);
        JOptionPane.showMessageDialog(null, "E l valor de c es : " + c);
        
        
        double aux = x;
        System.out.println("n" + "\t\t" + "X" + "\t\t" + "(ax+c)/m" + "\t\t" + "X" + "\t\t" + "Numeros Uniformes");
        for (int i = 0; i < m; i++) {
            //Calculo y presentacion
            int ax = (int) ((a * aux + c) / m);
            System.out.println("" + i + "\t\t" + aux + "\t\t" + ax + "+" + (a * aux + c) % m + "/" + m + "\t\t" + (a * aux + c) % m + "\t\t" + ((a * aux + c) % m) + "/" + m);
            aux = (a * aux + c) % m;
            if (x == aux) {
                break;
            }
        }

    }

    public static double primo_Cercano(double n) {
        int aux = 2;
        boolean b = true;

        while ((b) && (aux != n)) {
            if (n % aux == 0) {
                b = false;
            }
            aux++;
        }

        if (b) {
            return n;
        } else {
            return primo_Cercano(n - 1);
        }

    }

}
