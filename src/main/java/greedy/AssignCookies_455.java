package greedy;

import java.util.Arrays;

public class AssignCookies_455 {

    public static int findContentChildren(int[] g, int[] s) {

        // sort child by greed factor
        Arrays.sort(g);
        Arrays.sort(s);

        // assignment
        int content = 0;
        int childIndex = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[childIndex]) {
                content++;
                childIndex++;
            }
            if (childIndex >= g.length) {
                break;
            }
        }

        return content;
    }

    public static void main(String[] args) {

    }

}
