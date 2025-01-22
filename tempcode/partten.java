public class partten {
    void hollow_square(int n){
        int row = n , col = n ;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                if((i == 1|| i ==n) || j == 1 || j == n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    void rombus(int n){
        int row = n , col = n ;
        // String s = "";
        // // preprocess
        // for(int i =0;i<n;i++){
        //     s+="*";
        // }

        // for(int i =0;i<n;i++){
        //     for(int j = 0;j<i;j++){
        //         System.out.print(" ");
        //     }
        //     System.out.print(s);
        //     System.out.println();
        // }
        
        for(int i = 0;i<n;i++){
            // print spaace
            for(int s = 0;s<i;s++){
                System.out.print(" ");
            }
            // print star
            for(int j = 0;j<n;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }


    void Mirroredrombus(int n){
        int row = n , col = n ;
        for(int i = 0;i<n;i++){
            // print spaace
            for(int s = 0;s<n-i;s++){
                System.out.print(" ");
            }
            // print star
            for(int j = 0;j<n;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        
    }   

    void PyramidStarPattern(int n ){
        int temp = n+n-1;
        int mid = temp/2;
        mid = mid%2 == 0 ? mid : mid+1;
        int left = mid , right = mid;

        for(int i =0;i<n;i++){
            for(int l = 0;l<left;l++){
                System.out.print(" ");
            }
            for(int p = left;p<=right;p++){
                System.out.print("*");
            }
            for(int r = right;r<n;r++){
                System.out.print(" ");
            }
            left--;
            right++;
            System.out.println();
        }
        System.out.println("PyramidStarPattern");
        for (int i=0; i<n; i++) 
	        { 
	            for (int j=n-i; j>1; j--) 
	                System.out.print(" "); 
	            for (int j=0; j<=i; j++ ) 
	                System.out.print(" *"); 
	            System.out.println(); 
	        } 
    }

    void hollow_pyramid(int n){
        int temp = n+n-1;
        int mid = temp/2;
        mid = mid%2 == 0 ? mid : mid+1;
        int left = mid , right = mid;

        for(int i =0;i<n;i++){
            for(int l = 0;l<left;l++){
                System.out.print(" ");
            }
            for(int p = left;p<=right;p++){
                if(p == left || p == right || i == n-1)
                System.out.print("*");
                else System.out.print(" ");
            }
            for(int r = right;r<n;r++){
                System.out.print(" ");
            }
            left--;
            right++;
            System.out.println();
        }
    }

    void revPyramidStarPattern(int n){
        for (int i=n; i>0; i--) 
        { 
            for (int j=n-i; j>0; j--) 
                System.out.print(" "); 
            for (int j=0; j<i; j++ ) 
                System.out.print(" *"); 
            System.out.println(); 
        } 
    }

    public static void main(String[] args) {
        partten p = new partten();
        // p.hollow_square(10);
        // p.rombus(4);
        // p.Mirroredrombus(4);
        // p.PyramidStarPattern(4);
        // p.hollow_pyramid(6);
        p.revPyramidStarPattern(6);
        
    }
}
