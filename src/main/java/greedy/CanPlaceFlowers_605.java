package greedy;

public class CanPlaceFlowers_605 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int planted = 0;

        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {

            // one
            if (len == 1 && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                planted++;
            }

            // ÀY
            if (i == 0 && len > 1) {
                if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                    flowerbed[0] = 1;
                    planted++;
                }
            }

            // ¤¤¶¡
            if (i > 0 && i < len - 1) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] != 1) {
                    flowerbed[i] = 1;
                    planted++;
                }
            }

            // §À
            if (i == len - 1 && len > 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    planted++;
                }
            }
        }

        if (n > planted) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        Boolean ans = canPlaceFlowers(new int[] {1, 0, 1, 0, 1, 0, 1}, 1);
        System.out.println(ans);
        
    }

}
