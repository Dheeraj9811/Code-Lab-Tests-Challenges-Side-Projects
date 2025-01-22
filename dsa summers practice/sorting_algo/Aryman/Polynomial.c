int main(){
    int poly = 0;
    int n;
    scanf("%d", &n);
    int A[n];
    int x;
    scanf("%d",&x);
    for(int i = n-1; i >= 0 ; i--){
        poly = poly * x + A[i];
    }
    return 0;
}