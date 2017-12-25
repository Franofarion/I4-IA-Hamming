package test;

import main.Hamming;
import static org.junit.Assert.*;

public class HammingTest {

    public void main(String[] args) {
        try {
            testHammingClusters();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public final void testHammingClusters() throws Exception{
        boolean[][] hamming = {
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

        assertEquals(false,hamming[0][0]);
        assertEquals(true,hamming[9][3]);
        Hamming.hammingClusters(hamming);
    }
}
