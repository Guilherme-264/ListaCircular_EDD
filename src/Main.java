public class Main {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular<>();
        lista.adicionarNoFim("neyma");
        lista.adicionarNoFim("ViniJr");
        lista.adicionarNoInicio("little Couto");
        lista.adicionarNaPosicao("Pelé", 4);

        lista.exibir();

//        lista.removerNoFim();
//        lista.removerNoInicio();
        lista.removerPorValor("neyma");
//        lista.removerPorPosicao(4);
        System.out.println();
        lista.buscarPosicao("neyma");




    }
}