package main;

public class Hamming {

    /*
     */
    public static void hammingClusters(int[][] hamming){
        for (int[] x: hamming) {
            for(int y: x){
                System.out.print(y+" / ");
            }
            System.out.println();
        }
    }

    //INITIALISATION
    public static int[][] hammingDistance(boolean[][] echantillon){
        int index = 0;
        int[][] hamming = new int[echantillon.length][echantillon.length];
        return hammingDistance(echantillon, hamming, index);
    }

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
}
