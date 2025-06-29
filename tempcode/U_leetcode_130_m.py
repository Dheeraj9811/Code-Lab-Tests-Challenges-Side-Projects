from typing import List

class Solution:
    def solve(self, b: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        n, m = len(b) , len(b[0])

        colarr = []
        rowarr = []
        store = [] # used to store i , j
        for i in range(n):
            rowarr.append([])

        for i in range(m):
            colarr.append([])
            for j in range(n):
                if b[j][i] == "X":
                    colarr[i].append(j)
                    rowarr[j].append(i)
                else:
                    store.append((j,i))

        # for i in range(n):
        #     rowarr.append([])
        #     for j in range(m):
        #         if b[i][j] == "X":
        #             rowarr[i].append(j)
        for x , y in store:
            xlc = self.bsl(rowarr[x],y)
            xrc = self.bsr(rowarr[x],y)
            ylc  = self.bsl(colarr[y],x)
            yrc  = self.bsr(colarr[y],x)
            print("x:",x,"y:",y,"xlc:",xlc,"xrc:",xrc,"ylc:",ylc,"yrc:",yrc)
            if xlc != -1 and xrc != -1 and ylc != -1 and yrc != -1:
                b[x][y] = "X" 
        


    def bsl(self,arr,val):
        l , h = 0 , len(arr)-1
        ans = -1
        while(l<= h):
            mid = l + (h-l)//2

            if arr[mid] > val:
                h = mid -1
            else:
                ans = mid
                l = mid +1 
        return ans
    
    def bsr(self,arr,val):
        l , h = 0 , len(arr)-1
        ans = -1
        while(l<= h):
            mid = l + (h-l)//2

            if arr[mid] > val:
                ans = mid
                h = mid -1
            else:
                l = mid +1 
        return ans