package lab8;
import java.util.Random;
public class HashMapPlayground {
    
    void printExperimentalResultsTable(){
        final int N = 8192;
        final int SEED = 42;
        final double[] theory = {1.117, 1.282, 1.520, 1.885, 2.502, 3.590, 5.953, 13.137, 49.038};
        int currentSize;
        double i;
        int j;
        int k;
        double average = 0;
        Random rand = new Random();
        rand.setSeed(SEED);
        TitanProbeHashMap<Integer, String> map = new TitanProbeHashMap<Integer, String>(N);
        
        try{
        System.out.printf("L    Empirical ASMC    Theoretical ASMC\n");
        for ( i = 0.1; i < 0.5; i += 0.1){
                currentSize = (int)(i*N);
                for ( k = 0; k < 1000; k++ ){
                    map = new TitanProbeHashMap<Integer, String>(N);
                    for( j = 0; j < currentSize; j++ ){
                        map.put(rand.nextInt(), "-"); 
                        //I thought I coded it so it wouldn't matter what the value was, but that doesnt seem to work   
                    }
                    average += map.empiricalAverageSearchMissCost();
                }
                average /=1000;
            
            System.out.printf("%.1f  %5.3f             %5.3f\n", i, average, theory[(int)(i*10)] );
        }
        
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }  
}
