package old.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

class NumberOfDays {
        public static void main(String args[] ) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int numberOfTestCases = Integer.parseInt(br.readLine());
            for(int i=0; i<numberOfTestCases; i++){
                int size  = Integer.parseInt(br.readLine());
                int arr[] = Arrays.asList(br.readLine().split( ""))
                        .parallelStream()
                        .mapToInt(Integer::parseInt)
                        .toArray();

                int consecutiveSessionsAttedned = 0;
                int maxSession = 0;

                ArrayList<Integer> absentIndex = new ArrayList<>(size);
                for(int j=0; j<size; j++){
                    if(arr[j] == 0)
                        absentIndex.add(j);
                }

                for(int j=0; j<absentIndex.size(); j++){
                    if(j == 0) {
                        if(absentIndex.size() > 1)
                            consecutiveSessionsAttedned = absentIndex.get(j + 1);
                        else
                            consecutiveSessionsAttedned = size;
                    }
                    else if(absentIndex.size() == j+1)
                        consecutiveSessionsAttedned = size - absentIndex.get(j-1) -1;
                    else
                        consecutiveSessionsAttedned = absentIndex.get(j+1) -1 - absentIndex.get(j-1);

                    if(consecutiveSessionsAttedned > maxSession)
                        maxSession = consecutiveSessionsAttedned;
                }
                System.out.println(maxSession);

            }

        }
    }
