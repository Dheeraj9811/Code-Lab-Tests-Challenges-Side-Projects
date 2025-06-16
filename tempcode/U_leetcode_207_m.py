import sys
from collections import deque
from typing import List
sys.setrecursionlimit(2 * 10**4)

# visited = set()
# function to make graph from edges and return the graph as a dictionary
def make_graph(edges: list) -> dict:
    graph = {}
    for u, v in edges:
        if u not in graph:
            graph[u] = []
        if v not in graph:
            graph[v] = []
        graph[u].append(v)
        graph[v].append(u)  # Undirected graph
    return graph

# function to take input of edges
def take_input() -> list:
    n = int(input("Enter number of edges: "))
    edges = []
    for _ in range(n):
        u, v = map(int, input("Enter edge (u v): ").split())
        edges.append((u, v))
    return edges

def has_cycle_using_dsf(graph: dict, node: int, visited: set, parent: int) -> bool:
    visited.add(node)
    for neighbor in graph[node]:
        if neighbor not in visited:
            if has_cycle_using_dsf(graph, neighbor, visited, node):
                return True
        elif neighbor != parent:  # If the neighbor is visited and is not the parent
            return True
    return False


# detect cycle in undirected graph using bfs
def has_cycle_using_bfs(graph: dict, start: int, visited: set) -> bool:
    
    queue = deque([(start, -1)])  # (current node, parent node)
    
    while queue:
        node, parent = queue.popleft()
        visited.add(node)
        
        for neighbor in graph[node]:
            if neighbor not in visited:
                queue.append((neighbor, node))
            elif neighbor != parent:  # If the neighbor is visited and is not the parent
                return True
    return False

def has_cycle(graph: dict) -> bool:
    visited = set()
    for node in graph:
        if node not in visited:
            # if has_cycle_using_dsf(graph, node, visited, -1):
            if has_cycle_using_bfs(graph, node,visited):
                return True
    return False

def main():
    edges = take_input()
    graph = make_graph(edges)
    print("Graph representation:")
    show_graph(graph)
    
    if has_cycle(graph):
        print("Graph has a cycle")
    else:
        print("Graph does not have a cycle")

def show_graph(graph: dict):
    for node, neighbors in graph.items():
        print(f"{node}: {', '.join(map(str, neighbors))}")
if __name__ == "__main__":
    main()


#  prblem soln
class Solution:
    def canFinish(self, num: int, p: List[List[int]]) -> bool:
        # making graph
        graph = {}
        visi = [0]*num
        path = [0]*num
        
        for i in range(num):
            graph[i] = set()

        for u , v in p:
            graph[u].add(v)
        
        
        def dfs(node) -> bool:
            visi[node] = 1
            path[node] = 1

            for nbr in graph[node]:
                if visi[nbr] == 0:
                    if (dfs(nbr)):
                         return True
                elif (path[nbr] == 1):
                    return True
            
            path[node] = 0
            return False

        for i in range(num):
            if visi[i] == 0:
                if dfs(i):
                    return False
        return True