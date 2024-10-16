N = 10**2
size = [1 for _ in range(N)]
parent = [i for i in range(N)]

def find(u):
    if parent[u] == u:
        return u
    else:
        resultado = find(parent[u])
        parent[u] = resultado
        return resultado

def uniao(u, v):
    u = find(u)
    v = find(v)
    if u == v: return

    size[u] += size[v]
    parent[v] = u

n, m = [int(x) for x in input().split()]

arestas = []
for _ in range(m):
    u, v, c = [int(x) for x in input().split()]
    arestas.append((c,u,v))

arestas.sort()
custo = 0
for e in arestas:
    if find(e[1]) == find(e[2]): continue
    uniao(e[1], e[2])
    custo += e[0]

print(custo)