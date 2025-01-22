// C++ implementation to find the smallest sum
// contiguous subarray
#include <stdio.h>
int min(int a, int b){
    if(a>b){
        return b;
    }
    else{
        return a;
    }
}

// function to find the smallest sum contiguous subarray
int smallestSumSubarr(int arr[], int n)
{
	// to store the minimum value that is ending
	// up to the current index
	int min_ending_here = 1000000;
	
	// to store the minimum value encountered so far
	int min_so_far = 1000000;
	
	// traverse the array elements
	for (int i=0; i<n; i++)
	{
		// if min_ending_here > 0, then it could not possibly
		// contribute to the minimum sum further
		if (min_ending_here > 0)
			min_ending_here = arr[i];
		
		// else add the value arr[i] to min_ending_here
		else
			min_ending_here += arr[i];
		
		// update min_so_far
		min_so_far = min(min_so_far, min_ending_here);		
	}
	
	// required smallest sum contiguous subarray value
	return min_so_far;
}


// Driver program to test above
int main()
{
	int arr[] = {3, -4, 2, -3, -1, -7, -5};
	int n = sizeof(arr) / sizeof(arr[0]);
	printf("Smallest sum: %d", smallestSumSubarr(arr, n));
	return 0;	
}
