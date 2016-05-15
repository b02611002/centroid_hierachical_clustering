import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by zhouyuda on 5/14/16.
 *
 * This class implements a clustering algorithm called 'centroid hierarchical clustering algorithm' to
 * hierarchically group N 2-dimensional points in the plane.
 *
 * The clustering procedures are described as follows:
 *
 * Step 0: Treat each point as a cluster;
 * Step 1: Find the nearest pair of clusters (a, b) among the remaining N clusters
 * Step 2: Create a new cluster, c, of which the coordinates are the centroid of all the points it contains after
 *         merging the clusters a and b;
 * Step 3: Delete the two old clusters: a and b;
 * Step 4: N = N - 1;
 * Step 5: Re-calculate the distance of the new cluster, c, to other remaining clusters;
 * Step 6: Go to Step 1 unless N = 3;
 * Step 7: For each point in each cluster, find the nearest point in different cluster. e.g cluster A has 2 points a1,
 *         a2. cluster B has 2 points b1, b2, cluster C has 2 points c1, c2. compare the distance (a1, b1), (a1, b2),
 *         (a1, c1), (a1, c2), (a2, b1), (a2, b2), (a2, c1), (a2, c2), (b1, c1) and (b1, c2). print the smallest distance.
 *
 */
public class Clustering {
    public static void main(String[] args) throws Exception{

        //timer start
        long startTimems = System.currentTimeMillis();

        // read file
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))){
            int N = Integer.valueOf(br.readLine());
            String[] line;
            Point2D[] points = new Point2D[N];
            for(int i=0;br.ready();i++){
                line = br.readLine().split(" ");
                points[i] = new Point2D(Double.valueOf(line[0]),Double.valueOf(line[1]));
            }

            //TODO rm cmd
            System.out.println("*finished file reading");
        }



        //timer end
        long totalms = System.currentTimeMillis()-startTimems;
        int sec = (int) (totalms / 1000) % 60 ;
        int min = (int) ((totalms / (1000*60)) % 60);
        int hr   = (int) ((totalms / (1000*60*60)) % 24);
        // TODO rm
        System.out.printf("Program Finished. Runtime: %d ms (%dhr %dmin %dsec)\n",hr,min,sec,totalms);
    }
}
