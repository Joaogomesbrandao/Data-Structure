n, m = map(int, input().split())

lista_adj = [[] for x in range(n + 1)]

for i in range(m):
    u, v = map(int, input().split())

    lista_adj[u].append(v)
    lista_adj[v].append(u)

colors = [0 for _ in range(n + 1)]
is_bipartite = True
partition = [[], [], []]

def dfs(vertice, color):
    colors[vertice] = color
    next_color = 3 - color
    partition[color].append(vertice)

    for vizinho in lista_adj[vertice]:
        if colors[vizinho] == 0:
            dfs(vizinho, next_color)
        elif colors[vizinho] != next_color:
            is_bipartite = False

dfs(1,1)

if is_bipartite:
    print("The graph is bipartite")
    print(partition[1])
    print(partition[2])
else:
    print("The graph isn't bipartite")