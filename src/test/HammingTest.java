package test;

import main.Hamming;
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
        Hamming.hammingClusters(Hamming.hammingDistance(echantillon));
    }

    @org.junit.Test
    public final void testHammingClusters() throws Exception{
//        Hamming.hammingClusters(hamming);
    }
}
