from queue import Queue

n, m = map(int, input().split())
s = int(input())

lista_adj = [[] for x in range(n + 1)]

for _ in range(m):
    u, v = map(int, input().split())

    lista_adj[u].append(v)
    lista_adj[v].append(u)

fila = Queue()
fila.put(s)
dist = [-1 for _ in range(n + 1)]
dist[s] = 0

while not fila.empty():
    nx = fila.get()

    for v in lista_adj[nx]:
        if dist[v] != -1: continue
        dist[v] = dist[nx] + 1
        fila.put(v)

for i in range(1, n + 1):
    print(i, ":", dist[i])