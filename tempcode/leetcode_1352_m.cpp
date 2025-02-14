#include<bits/stdc++.h>
using namespace std;

class ProductOfNumbers {
public:
    vector<int> presum;
    vector<int> zeroind;

    ProductOfNumbers() {
        presum.push_back(1); // Initialize with 1-based indexing
    }
    
    void add(int num) {
        if (num == 0) {
            zeroind.push_back(presum.size()); // Store 1-based index of zero
            presum.push_back(1); // Reset product sequence
            return;
        }
        presum.push_back(presum.back() * num);
    }
    
    int getProduct(int k) {
        int n = presum.size(); // 1-based indexing
        int start = n - k;
        int end = n - 1;

        // Check if any zero exists in this range
        for (int i = 0; i < zeroind.size(); i++) {
            if (zeroind[i] >= start ) {
                return 0;
            }
        }

        return presum[end] / presum[start - 1];
    }
};
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers* obj = new ProductOfNumbers();
 * obj->add(num);
 * int param_2 = obj->getProduct(k);
 * 
 * 1 2 3 4 5 6 7 8 9 10
 * 2 2 2 2 2 0
 */

