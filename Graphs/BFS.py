from queue import Queue

n, m = map(int, input().split())

lista_adj = [[] for x in range(n + 1)]

for _ in range(m):
    u, v = map(int, input().split())

    lista_adj[u].append(v)
    lista_adj[v].append(u)

visitado = [False for _ in range(n + 1)]

fila = Queue()
fila.put(1)
visitado[1] = True

while not fila.empty():
    vertice = fila.get()

    print("visitando o vértice ", vertice)

    for vizinho in lista_adj[vertice]:
        if not visitado[vizinho]:
            visitado[vizinho] = True
            fila.put(vizinho)