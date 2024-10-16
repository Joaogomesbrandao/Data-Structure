n, m = map(int, input().split())

lista_adj = [[] for x in range(n + 1)]

for i in range(m):
    u, v = map(int, input().split())

    lista_adj[u].append(v)
    lista_adj[v].append(u)

visitado = [False for _ in range(n + 1)]

def dfs(vertice):
    if visitado[vertice]: return
    visitado[vertice] = True

    for vizinho in lista_adj[vertice]: dfs(vizinho)