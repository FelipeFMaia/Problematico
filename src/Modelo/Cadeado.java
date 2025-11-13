package Modelo;
import Auxiliar.Desenho;

public class Cadeado extends Personagem {
    public Cadeado(String sNomeImagePNG, int linha, int coluna) {
        super(sNomeImagePNG, linha, coluna);
        
        // V-V-V MUDANÇA CRÍTICA V-V-V
        this.bTransponivel = true; // DEVE ser transponível para a colisão ser processada
        // ^-^-^ FIM DA MUDANÇA ^-^-^
    }

    @Override public void atualizar(java.util.ArrayList<Personagem> faseAtual, Hero hero) {}

    @Override
    public String aoColidirComHeroi(Hero h) {
        if (h.temChave()) {
            h.usarChave();
            Desenho.acessoATelaDoJogo().removePersonagem(this); // Se auto-remove
            return "GAME_RUNNING"; // Sucesso! Herói fica no tile.
        }
        
        // V-V-V MUDANÇA CRÍTICA V-V-V
        // Não tem chave? Aja como uma parede e "empurre" o herói
        return "REJEITADO"; 
        // ^-^-^ FIM DA MUDANÇA ^-^-^
    }
}