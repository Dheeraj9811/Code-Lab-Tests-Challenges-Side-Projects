from typing import List, Set, Tuple
from collections import defaultdict
import bisect
# A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot receives an array of integers commands, which represents a sequence of moves that it needs to execute. There are only three possible types of instructions the robot can receive:

# -2: Turn left 90 degrees.
# -1: Turn right 90 degrees.
# 1 <= k <= 9: Move forward k units, one unit at a time.
# Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). If the robot runs into an obstacle, it will stay in its current location (on the block adjacent to the obstacle) and move onto the next command.

# Return the maximum squared Euclidean distance that the robot reaches at any point in its path (i.e. if the distance is 5, return 25).
class Solution:
    
    def first_in_range(self, arr, a, b):
        lo, hi = sorted((a, b))  # fix for negative range or reversed direction
        idx = bisect.bisect_left(arr, lo)
        if idx < len(arr) and arr[idx] <= hi:
            return arr[idx]
        return None
    
    def new_coordinate(self, dir, x, y, move, obstacles_map_y ,obstacles_map_x , skip_obstacle_check =False) -> Tuple[int, int]:
        if skip_obstacle_check:
            # First move from origin: ignore obstacle at (0, 0)
            move = move - 1
            if dir == 0: 
                x,y =  x - 1, y # west
            if dir == 1: x,y =  x, y + 1       # north
            if dir == 2: x,y =  x + 1, y       # east
            if dir == 3: x,y =  x, y - 1       # south
        print(f"new x and y is : {x} , {y}")
        if dir == 2:
            # moving south/down
            x_n, y_n = x + move, y
            # check for obstacles in the path
            # checking in x
            obs = self.first_in_range(obstacles_map_x[y], x, x_n)
            if obs is not None:
                print(f"obs is {obs} and y_obs is {y_n}")
                return obs - 1, y_n
            
            return x_n, y_n 
            
        elif dir == 3:
            x_n , y_n = x, y - move
            # check for obstacles in the path
            # checking in x
            obs = self.first_in_range(obstacles_map_y[x_n], y, y_n)
            if obs is not None:
                print(f"obs is {x_n} and y_obs is {obs}")
                return x_n, obs + 1
            return x_n, y_n
        elif dir == 0:
            x_n, y_n = x - move, y
            # check for obstacles in the path
            # checking in x
            obs = self.first_in_range(obstacles_map_x[y], x_n, x)
            if obs is not None:
                print(f"obs is {obs} and y_obs is {y_n}")
                return obs + 1, y_n
            return x_n, y_n
        elif dir == 1:
            x_n, y_n = x, y + move
            # check for obstacles in the path
            # checking in x
            obs = self.first_in_range(obstacles_map_y[x], y_n, y)
            if obs is not None:
                print(f"obs is {x_n} and y_obs is {obs}")
                return x_n, obs - 1
            return x_n, y_n
        
        



    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        # making map of obsticle to get in O(1), using set
        obstacles_map_y = defaultdict(list)
        obstacles_map_x = defaultdict(list)
        for x, y in obstacles:
            obstacles_map_y[x].append(y)
            obstacles_map_x[y].append(x)
            

        # sort the obstacles to make sure we can check them in order
        for x in obstacles_map_y:
            obstacles_map_y[x] = sorted(obstacles_map_y[x])
        for y in obstacles_map_x:
            obstacles_map_x[y] = sorted(obstacles_map_x[y])
        ans = 0
        pass_origin = False
        direction = 1
        c_x , c_y = 0, 0  # current coordinates
        for val in commands:
            if val == -2:
                direction = (direction -1 ) % 4
            elif val == -1:
                direction = (direction + 1) % 4
            else:
                if not pass_origin :
                    c_x, c_y = self.new_coordinate(direction, c_x, c_y, val, obstacles_map_y, obstacles_map_x, skip_obstacle_check=True)
                    pass_origin = True
                else:
                    c_x, c_y = self.new_coordinate(direction, c_x, c_y, val, obstacles_map_y, obstacles_map_x)
            ans = max(ans, c_x**2 + c_y**2)
        return ans    






        

        