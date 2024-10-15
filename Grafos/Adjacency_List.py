#This code reads two integers that represent the number of vertices and edges,
#as well as the pairs of vertices that will be connected and builds an adjacency list.

n, m = map(int, input().split())

lista_adj = [[] for x in range(n + 1)]

for i in range(m):
    u, v = map(int, input().split())

    lista_adj[u].append(v)
    lista_adj[v].append(u)

for i in range(n + 1): print(lista_adj[i])