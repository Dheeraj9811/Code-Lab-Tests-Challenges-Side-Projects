from collections import defaultdict

# 269. Alien Dictionary
# There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

# Example 1:

# Input:
# [
#   "wrt",
#   "wrf",
#   "er",
#   "ett",
#   "rftt"
# ]

# Output: "wertf"
# Example 2:

# Input:
# [
#   "z",
#   "x"
# ]

# Output: "zx"
# Example 3:

# Input:
# [
#   "z",
#   "x",
#   "z"
# ]

# Output: "" 

# Explanation: The order is invalid, so return "".
# Note:

# You may assume all letters are in lowercase.
# You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
# If the order is invalid, return an empty string.
# There may be multiple valid order of letters, return any one of them is fine.
# Difficulty:
# Hard

class Solution:
    
    def findOrder(self,words) -> str:
        visi = [False]*26
        path = [False]*26
        store = []
        def make_graph(words) -> dict:
            graph = defaultdict(set)
            for word in words:
                for c in word:
                    graph[c]
            for i in range(len(words)-1):
                
                word1 = words[i]
                word2 = words[i+1]
                for a , b in zip(word1 , word2):
                    if a != b:
                        graph[a].add(b)
                        break
                else:
                    if len(word1) > len(word2):
                        return {}
            return graph
        graph = make_graph(words)

        if len(graph) == 0: return "here"
        # checking cycle
        def dfs(node, visi,path,store):
            curr = ord(node) - ord('a')
            visi[curr] = True
            path[curr] = True

            for nbr in graph[node]:
                nbrv = ord(nbr) - ord('a')
                if not visi[nbrv]:
                    if dfs(nbr,visi,path,store):
                        return True
                elif path[nbrv]:
                    return True
            
            path[curr] = False
            store.append(node)
            return False
        
        for node in graph:
            curr = ord(node) - ord('a')            
            if not visi[curr]:
                if dfs(node , visi, path,store):
                    return "not possible"
        store.reverse()
        
        return store
    

# main 
if __name__ == "__main__":
    # words = ["baa", "abcd", "abca", "cab", "cad"]
    # words = ["ab", "cd", "ef", "ad"]
    words = ["z", "z"]
    sol = Solution()
    order = sol.findOrder(words)
    print(order)  # Output: "wertf"
