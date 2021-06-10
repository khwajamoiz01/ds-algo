package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IT3 {

    public int solution(int[][] ar) {
        if (ar == null)
            return -1;
        Map<Integer, Set<Integer>> doctorAndHospitalsMap = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                if (!doctorAndHospitalsMap.containsKey(ar[i][j])) {
                    doctorAndHospitalsMap.put(ar[i][j], new HashSet<>());
                }
                Set<Integer> hospitals = doctorAndHospitalsMap.get(ar[i][j]);
                hospitals.add(i);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : doctorAndHospitalsMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                res++;
            }
        }
        return res;
    }
}
