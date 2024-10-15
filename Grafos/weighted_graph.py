n, m = map(int, input().split())

lista_adj = [[] for x in range(n + 1)]
matriz_adj = [[0] * (n + 1) for x in range(n + 1)]

for i in range(m):
    u, v, peso = map(int, input().split())

    lista_adj[u].append((v, peso))
    matriz_adj[u][v] = peso

for i in range(n + 1): print(lista_adj[i])
for i in range(n + 1): print(matriz_adj[i])