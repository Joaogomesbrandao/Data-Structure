#This code reads two integers that represent the number of vertices and edges,
#as well as the pairs of vertices that will be connected and builds an adjacency matrix.

n, m = map(int, input().split())

matriz_adj = [[0] * (n + 1) for x in range(n + 1)]

for i in range(m):
    u, v = map(int, input().split())

    matriz_adj[u][v] = 1
    matriz_adj[v][u] = 1

for i in range(n + 1): print(matriz_adj[i])