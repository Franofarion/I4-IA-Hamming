package main;

import java.util.ArrayList;
import java.util.List;

public class Hamming {


    /**
     *
     * @param hamming, le tableau des distances de Hammings
     * @param clusters, la liste de liste de nombre, qui représente la liste des clusteurs
     * @param clusterNumber, le nombre de cluster que l'on souhaite dans notre liste 'clusters'
     * @return
     */
    public static List<List<Integer>> hammingMain(int[][] hamming, List<List<Integer>> clusters, int clusterNumber){
        if(clusters.size() >= clusterNumber){
            return clusters;
        } else {
            if (clusters.size() <= 0) {
                return hammingMain(hamming, hammingClusters(hamming, new ArrayList<>()), clusterNumber);
            } else {
                // GET THE LARGER LIST OF THE LIST (index)
                int maxLength = 0;
                List<Integer> biggerIndex = new ArrayList<>();
                for (List<Integer> ind : clusters) {
                    if (ind.size() > maxLength) {
                        maxLength = ind.size();
                        biggerIndex = ind;
                    }
                }
                clusters.remove(biggerIndex);
                List<List<Integer>> newIndex = hammingClusters(hamming, biggerIndex);
                clusters.add(newIndex.get(0));
                clusters.add(newIndex.get(1));
                return hammingMain(hamming, clusters,clusterNumber);
            }
        }
    }

    /**
     *
     * @param hamming
     * @param index
     * @return
     */
    public static List<List<Integer>> hammingClusters(int[][] hamming, List<Integer> index){
        List<List<Integer>> clusters = new ArrayList<List<Integer>>(2);
        List<Integer> internalCluster = new ArrayList<Integer>();
        List<Integer> externalCluster = new ArrayList<Integer>();

        // Boucle servant à determiner la moitié entre la plus haute et la plus faible distance de Hamming de l'index demandé = half
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int x = 0; x < hamming.length; x++) {
            for(int y = 0; y < hamming[x].length; y++){
                if((index.contains(x) && index.contains(y)) || index.isEmpty()){
                    max =  hamming[x][y] > max ? hamming[x][y] : max;
                    min =  hamming[x][y] < min ? hamming[x][y] : min;
                }
            }
        }
        double half = Math.floor((max + min) / 2);

        // Boucle pour le clustering
        for (int i = 0; i < hamming.length; i++) {
            double maxValue = 0;
            for(int j = 0; j < hamming[i].length; j++) {
                if((index.contains(i) && index.contains(j)) || index.isEmpty()) {
                    maxValue = hamming[i][j] > maxValue ? hamming[i][j] : maxValue;
                }
            }
            for(int j = 0; j < hamming[i].length; j++){
                if((index.contains(i) && index.contains(j)) || index.isEmpty()){
                    if(!internalCluster.contains(j) && !externalCluster.contains(i) && i != j){
                        //si la distance est supérieur à la moyenne,
                        // ou si la taille du tableau d'index est égale à deux (car on est forcé d'avoir un index dans chaque cluster)
                        // ou si la valeur maximal de la ligne est égale à la valeur half
                        // alors on ajoute l'index j au cluster externe et i au cluster interne
                        if((hamming[i][j] > half || index.size() == 2 || maxValue == half)){
                            externalCluster = pushIfNotAlreadyExist(externalCluster, j);
                            internalCluster = pushIfNotAlreadyExist(internalCluster, i);
                        }
                    }
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
