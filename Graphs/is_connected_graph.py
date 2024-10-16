n, m = [int(x) for x in input().split()]
lista_adj = [[] for _ in range(n + 1)]
vis = [False for _ in range(n + 1)]

for _ in range(m):
    u, v = [int(x) for x in input().split()]
    lista_adj[u].append(v)
    lista_adj[v].append(u)

def dfs(i):
    if vis[i]: return
    vis[i] = True
    for v in lista_adj[i]:
        dfs(v)

resposta = 0
for i in range(1, n + 1):
    if vis[i] == False:
        resposta += 1
        dfs(i)

print(resposta)