package sistema;

public class ConjuntoDisjunto {

    private int[] padre;
    private int[] rango;

    public ConjuntoDisjunto(int n) {
        padre = new int[n];
        rango = new int[n];
        for (int i = 0; i < n; i++) {
            padre[i] = i;
        }
    }

    public int encontrar(int x) {
        if (padre[x] != x) {
            padre[x] = encontrar(padre[x]);
        }
        return padre[x];
    }

    public void unir(int x, int y) {
        int raizX = encontrar(x);
        int raizY = encontrar(y);
        if (raizX == raizY) {
            return;
        }
        if (rango[raizX] < rango[raizY]) {
            padre[raizX] = raizY;
        } else if (rango[raizX] > rango[raizY]) {
            padre[raizY] = raizX;
        } else {
            padre[raizY] = raizX;
            rango[raizX]++;
        }
    }
}
