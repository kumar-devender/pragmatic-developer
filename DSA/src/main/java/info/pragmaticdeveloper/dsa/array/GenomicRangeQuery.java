package info.pragmaticdeveloper.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {
    private static final Map<Character, Integer> IMPACT_FACTOR = new HashMap<>();

    static {
        IMPACT_FACTOR.put('A', 1);
        IMPACT_FACTOR.put('C', 2);
        IMPACT_FACTOR.put('G', 3);
        IMPACT_FACTOR.put('T', 4);
    }

    public int[] getMinimalImpactFactor(String input, int[] P, int[] Q) {
        int[] a = new int[input.length()];
        int[] c = new int[input.length()];
        int[] g = new int[input.length()];
        int[] t = new int[input.length()];

        int A = 0, C = 0, G = 0, T = 0;


        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'A') {
                A++;
            }
            if (input.charAt(i) == 'C') {
                C++;
            }
            if (input.charAt(i) == 'G') {
                G++;
            }
            if (input.charAt(i) == 'T') {
                T++;
            }
            a[i] = A;
            c[i] = C;
            g[i] = G;
            t[i] = T;
        }
        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            if (P[i] == Q[i]) {
                result[i] = IMPACT_FACTOR.get(input.charAt(P[i]));
            } else if (a[P[i]] < a[Q[i]] || input.charAt(P[i]) == 'A') {
                result[i] = 1;
            } else if (c[P[i]] < c[Q[i]] || input.charAt(P[i]) == 'C') {
                result[i] = 2;
            } else if (g[P[i]] < g[Q[i]] || input.charAt(P[i]) == 'G') {
                result[i] = 3;
            } else if (t[P[i]] < t[Q[i]] || input.charAt(P[i]) == 'T') {
                result[i] = 4;
            }
        }
        return result;
    }
}
