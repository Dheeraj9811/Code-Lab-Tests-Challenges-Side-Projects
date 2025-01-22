#include <bits/stdc++.h>  
  
using namespace std;  
unsigned long long power(unsigned long long x, int y, int p)  
{  
    unsigned long long res = 1; // Initialize result  
   
    x = x % p; // Update x if it is more than or  
    // equal to p  
   
    while (y > 0) {  
   
        // If y is odd, multiply x with result  
        if (y & 1)  
            res = (res * x) % p;  
   
        // y must be even now  
        y = y >> 1; // y = y/2  
        x = (x * x) % p;  
    }  
    return res;  
}  
   
// Returns n^(-1) mod p  
unsigned long long modInverse(unsigned long long n, int p)  
{  
    return power(n, p - 2, p);  
}  
unsigned long long mul(unsigned long long x,  
                       unsigned long long y, int p)  
{  
    return x * 1ull * y % p;  
}  
unsigned long long divide(unsigned long long x,  
                          unsigned long long y, int p)  
{  
    return mul(x, modInverse(y, p), p);  
}  
// Returns nCr % p using Fermat's little  
// theorem.  
unsigned long long nCrModPFermat(unsigned long long n,  
                                 int r, int p)  
{  
    // If n<r, then nCr should return 0  
    if (n < r)  
        return 0;  
    // Base case  
    if (r == 0)  
        return 1;  
    // if n-r is less calculate nCn-r  
    if (n - r < r)  
        return nCrModPFermat(n, n - r, p);  
   
    // Fill factorial array so that we  
    // can find all factorial of r, n  
    // and n-r  
    unsigned long long res = 1;  
    // keep multiplying numerator terms and dividing denominator terms in res  
    for (int i = r; i >= 1; i--)  
        res = divide(mul(res, n - i + 1, p), i, p);  
    return res;  
}  
long long solve(int N,int K,string S){  
    int mod=1e9+7;  
    if(K>26)return 0;  
    map<char,int>mp;  
  
  
    for(auto x:S){  
        mp[x]++;  
    }  
  
  
    vector<long long>freq(26);  
    for(auto x:mp){  
        freq[x.first-'a']++;  
    }  
  
    map<int,int>mp2;  
  
    for(auto x:freq){  
        mp2[x]++;  
    }  
  
    vector<vector<long long>>v;  
  
    for(auto x:mp2){  
        v.push_back({x.first,x.second});  
    }  
  
    sort(v.begin(),v.end(),greater<vector<long long>>());  
  
    long long ans=1;  
  
    for(int i=0;i<v.size();i++){  
        if(K>v[i][1]){  
            ans*=v[i][0];  
            ans%=mod;  
            ans*=v[i][1];  
            K-=v[i][1];  
        }  
        else{  
  
            ans*=nCrModPFermat(v[i][1],K,mod);  
            ans%=mod;  
            ans*=v[i][0];  
  
            ans%=mod;  
  
            ans*=K;  
            ans%=mod;  
            break;  
        }  
        return ans;  
          
    }