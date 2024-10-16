from queue import PriorityQueue

n,m = [int(x) for x in input().split()]
s = int(input())
lista_adj = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v, c = [int(x) for x in input().split()]
    lista_adj[u].append((v, c))
    lista_adj[v].append((u, c))

fila = PriorityQueue()
fila.put((0, s))

dist = [float('inf') for _ in range(n + 1)]
dist[s] = 0

while not fila.empty():
    nx = fila.get()
    vert = nx[1]
    d = nx[0]
    if dist[vert] != d: continue
    print(vert, d)
    for e in lista_adj[vert]:
        v = e[0]
        peso = e[1]
        if dist[v] <= d + peso: continue
        dist[v] = d + peso
        fila.put((dist[v], v))

for i in range(1, n + 1):
    print(i, ":", dist[i])