package test;

import main.Hamming;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HammingTest {

    public void main(String[] args) {
        try {
            testHammingDistance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public final void testHammingDistance() throws Exception{
        boolean[][] echantillon = {
                            {false,true,true,false},
                            {false,false,true,false},
                            {true,true,true,false},
                            {false,true,false,false},
                            {false,true,true,true},
                            {false,false,false,true},
                            {true,true,true,true},
                            {true,false,false,false},
                            {true,false,false,true},
                            {true,true,false,true},
                        };

        assertEquals(false,echantillon[0][0]);
        assertEquals(true,echantillon[9][3]);


        List<List<Integer>> list = new ArrayList<List<Integer>>();
        assertEquals(0,list.size());

        int[][] hammingArray = Hamming.hammingDistance(echantillon);
        System.out.println(Hamming.hammingMain(hammingArray, list, 10).toString());
    }

    @org.junit.Test
    public final void testHammingClusters() throws Exception{
//        Hamming.hammingClusters(hamming);
    }

 /*   @org.junit.Test
    public final void testPushIfNotAlreadyExist() throws Exception{
        List<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test = Hamming.pushIfNotAlreadyExist(test,4);
        System.out.println(test);
        test = Hamming.pushIfNotAlreadyExist(test,5);
        System.out.println(test);
    }*/
}
