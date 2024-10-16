from queue import Queue
n, m = map(int, input().split())

lista_adj = [[] for x in range(n + 1)]

for i in range(m):
    u, v = map(int, input().split())

    lista_adj[u].append(v)
    lista_adj[v].append(u)

distancia = [-1 for _ in range(n + 1)]

fila = Queue()
fila.put(1)
distancia[1] = 0

while not fila.empty():
    vertice = fila.get()

    for vizinho in lista_adj[vertice]:
        if distancia[vizinho] == -1:
            distancia[vizinho] = distancia[vertice] + 1
            fila.put(vizinho)