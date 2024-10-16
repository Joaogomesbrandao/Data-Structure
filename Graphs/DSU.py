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
