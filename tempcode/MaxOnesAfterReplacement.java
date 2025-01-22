public class MaxOnesAfterReplacement {
    public static int maxOnesAfterReplacement(String s) {
        int maxOnes = 0; // Maximum number of ones seen so far
        int countZeros = 0; // Count of consecutive zeros
        int left = 0; // Left pointer for the sliding window
        int totalone = 0;
        
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                countZeros++;
            }
            else{
                totalone++;
            }
            
            // If there are more than 1 consecutive zeros, move the left pointer
            while (countZeros > 1) {
                if (s.charAt(left) == '0') {
                    countZeros--;
                }
                left++;
            }
            
            // Update maxOnes with the length of the current window
            maxOnes = Math.max(maxOnes, right - left + 1);
        }
        
        return totalone+maxOnes;
    }
    
    public static void main(String[] args) {
        String binaryString = "01";
        int maxOnes = maxOnesAfterReplacement(binaryString);
        System.out.println("Maximum number of ones after replacement: " + (maxOnes-1));
    }
}

// public class MaxOnesAfterReplacement {
//     public static int maxSolarPoweredBulbs(String bulbs) {
//         int maxBulbs = 0;
//         int consecutiveZeros = 0;

//         for (int i = 0; i < bulbs.length(); i++) {
//             if (bulbs.charAt(i) == '0') {
//                 consecutiveZeros++;
//             } else {
//                 maxBulbs += (consecutiveZeros + 1) / 2;
//                 consecutiveZeros = 0;
//                 maxBulbs++; // Count the current 1
//             }
//         }

//         maxBulbs += (consecutiveZeros + 1) / 2; // Handling trailing consecutive zeros

//         return maxBulbs;
//     }


//     public static void main(String[] args) {
//         String bulbs = "00001000100001110010010010111100001";
//         int maxSolarBulbs = maxSolarPoweredBulbs(bulbs);
//         System.out.println("Maximum number of solar powered bulbs: " + maxSolarBulbs);
//     }
// }
