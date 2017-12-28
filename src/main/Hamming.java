package main;

import java.util.ArrayList;
import java.util.List;

public class Hamming {

    /**
     *
     * @param hamming
     * @return
     */
    public static List<List<Integer>> hammingClusters(int[][] hamming){
        List<List<Integer>> clusters = new ArrayList<List<Integer>>(2);
        List<Integer> internalCluster = new ArrayList<Integer>();
        List<Integer> externalCluster = new ArrayList<Integer>();
        double moyenne = 0;
        int dividende = 0;

        //Boucle for pour calculer la moyenne
        for (int[] x: hamming) {
            for(int y: x){
                System.out.print(y + " / ");
                moyenne += y;
                dividende ++;
            }
            System.out.println();
        }
        // On fait la moyenne au dessus
        moyenne = Math.ceil(moyenne / dividende);
        System.out.println("moyenne = " + moyenne);

        // Boucle pour le clustering
        for (int i = 0; i < hamming.length; i++) {
            for(int j = 0; j < hamming[i].length; j++){
                //si la distance est supérieur à la moyenne, alors on ajoute l'index j au cluster externe

                if(hamming[i][j] > moyenne && !internalCluster.contains(j) && !externalCluster.contains(i)){
                    externalCluster = pushIfNotAlreadyExist(externalCluster, j);
                    internalCluster = pushIfNotAlreadyExist(internalCluster, i);
                }
            }
        }
        clusters.add(internalCluster);
        clusters.add(externalCluster);
        return clusters;
    }

    /**
     *
     * @param echantillon
     * @return
     */
    public static int[][] hammingDistance(boolean[][] echantillon){
        int index = 0;
        int[][] hamming = new int[echantillon.length][echantillon.length];
        return hammingDistance(echantillon, hamming, index);
    }

    /**
     *
     * @param echantillon
     * @param hamming
     * @param index
     * @return
     */
    public static int[][] hammingDistance(boolean[][] echantillon, int[][] hamming, int index){
        if(echantillon.length <= index){
            return hamming;
        }else{
            for(int i = 0; i < echantillon.length; i++){
                int dist = 0;
                for(int j = 0; j < echantillon[i].length; j++){
                    if(echantillon[index][j] != echantillon[i][j]){
                        dist++;
                    }
                }
                hamming[index][i] = dist;
            }
            return hammingDistance(echantillon, hamming, index+1);
        }
    }

    public static List<Integer> pushIfNotAlreadyExist(List<Integer> array, int value){
        if(array.contains(value)){
            return array;
        } else {
            array.add(value);
            return array;
        }
    }
}
