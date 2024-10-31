public class ListaCircular<T> {
    private No<T> inicio;
    private No<T> fim;

    public ListaCircular(){
        this.inicio = null;
        this.fim = null;
    }

    public void adicionarNoFim(T elemento){
        No<T> novoNo = new No<>(elemento);
        if (inicio == null){
            inicio = novoNo;
            fim = novoNo;
        }else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
            fim.proximo = inicio;
        }
    }

    public void adicionarNoInicio(T elemento){
        No<T> novoNo = new No<>(elemento);
        if (inicio == null){
            inicio = novoNo;
            fim = novoNo;
        }else {
            inicio.anterior = novoNo;
            novoNo.proximo = inicio;
            inicio = novoNo;
            fim.proximo = inicio;
        }
    }

    public void adicionarNaPosicao(T elemento, int posicao){
        No<T> novoNo = new No<>(elemento);
        No posicaoAtual = inicio;
        if (inicio == null){
            System.out.println("A lista está vázia");
            return;
        }

        if (posicao == 1){
            inicio.anterior = novoNo;
            novoNo.proximo = inicio;
            inicio = novoNo;
            fim.proximo = inicio;
            return;
        }
        for (int i = 0; i <= posicao; i++) {
            if (posicaoAtual != null) {
                posicaoAtual = posicaoAtual.proximo;
            }else {
                System.out.println("a playlist não possui " + posicao +" músicas");
                return;
            }
        }
        if ( posicaoAtual.proximo == inicio){
            novoNo.anterior = fim;
            fim.proximo = novoNo;
            fim = novoNo;
            fim.proximo = inicio;

        }else if (posicaoAtual.proximo != null){
            No temp = posicaoAtual.proximo;
            posicaoAtual.proximo = novoNo;
            temp.anterior = novoNo;
            novoNo.proximo = temp;
            novoNo.anterior = posicaoAtual;
        }else {
            posicaoAtual.proximo = novoNo;
            novoNo.anterior = posicaoAtual;
            fim = novoNo;

        }
    }

    public void removerPorValor(T elemento){
        if (inicio == null){
            System.out.println("A lista está vazia");
            return;
        }
        No<T> atual = inicio;
        do {
            if (atual.elemento.equals(elemento)) {
                if (atual.proximo == null){
                    inicio = null;
                    fim = null;
                    return;
                }
                if (atual == inicio) {
                    inicio = inicio.proximo;
                    fim.proximo = inicio;
                    inicio.anterior = null;

                    return;
                }

                if (atual == fim) {
                    fim = atual.anterior;
                    fim.proximo = inicio;
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
                return;
            }
            atual = atual.proximo;
        }while(atual != inicio );

        System.out.println("O elemento não existe na lista");
    }

    public void removerPorPosicao(int posicao){
        No posicaoAtual = inicio;
        if (inicio == null){
            System.out.println("A lista está vázia");
            return;
        }
        if (posicao == 1 && inicio.proximo == null){
            inicio = null;
            System.out.println("elemento da lista removido");
            return;
        }else if (posicao == 1){
            inicio = inicio.proximo;
            inicio.anterior = null;
            fim.proximo = inicio;
            System.out.println("elemento da lista removido");
        }else {
            for (int i = 2; i <= posicao; i++) {
                posicaoAtual = posicaoAtual.proximo;
            }
            if (posicaoAtual == inicio && inicio.proximo == null){
                inicio = null;
                System.out.println("elemento da lista removido");
                return;
            }else if (posicaoAtual == inicio) {
                inicio = inicio.proximo;
                inicio.anterior = null;
                fim.proximo = inicio;
                System.out.println("elemento da lista removido");
            }else if (posicaoAtual == fim){
                fim = fim.anterior;
                fim.proximo = inicio;
                System.out.println("elemento da lista removido");
            }else {
                posicaoAtual.anterior.proximo = posicaoAtual.proximo;
                posicaoAtual.proximo.anterior = posicaoAtual.anterior;
            }
        }

    }

    public void removerNoInicio(){
        if (inicio == null){
            System.out.println("A lista esta vazia");
        }else if (inicio.proximo == null){
            inicio = null;
            fim = null;
        }
        else {
            inicio = inicio.proximo;
            fim.proximo = inicio;
            inicio.anterior = null;
            System.out.println("primeiro elemento da lista removido");
        }
    }

    public void removerNoFim(){

        if (inicio == null){
            System.out.println("A lista esta vazia");
        }else if (fim.proximo == fim){
            inicio = null;
            fim = null;
        }else {
            fim = fim.anterior;
            fim.proximo = inicio;
            System.out.println("ultimo elemento da lista removido");
        }
    }

    public void exibir(){
        if (inicio == null){
        System.out.println("lista vazia");
        return;
        }
        No<T> atual = inicio;
        if(atual.proximo == null){
            System.out.println(atual.elemento);
        }else {
            do {
                System.out.println(atual.elemento);
                atual = atual.proximo;
            }
            while (atual != inicio);
        }
    }

    public void buscar(int posicao){
        if (inicio == null){
            System.out.println("A lista está vazia");
            return;
        }
        if (posicao == 1 ){
            System.out.println(inicio.elemento);
            return;
        } else{
            No posicaoAtual = inicio;
            for (int i = 2; i <= posicao; i++) {
                posicaoAtual = posicaoAtual.proximo;
            }
            System.out.println(posicaoAtual.elemento);
        }

    }

    public void buscarPosicao(T valor){
        if (inicio == null){
            System.out.println("lista está vazia");
        }else {
            int posicao = 1;
            No posicaoAtual = inicio;
            do {
                if (posicaoAtual.elemento.equals(valor) ){
                    System.out.println(posicao);
                    return;
                }
                posicao++;
                posicaoAtual = posicaoAtual.proximo;
            }while(posicaoAtual != inicio);
            System.out.println("-1");
        }


    }
}
