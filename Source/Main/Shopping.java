public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int quantidadeMaximaLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaximaLojas];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Shopping: ").append(nome).append("\n")
          .append("Endereço: ").append(endereco).append("\n")
          .append("Lojas:\n");

        for (Loja loja : lojas) {
            if (loja != null) {
                sb.append(loja).append("\n");
            }
        }

        return sb.toString();
    }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equals(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipoLoja) {
        int count = 0;
        for (Loja loja : lojas) {
            if (loja != null && loja.getClass().getSimpleName().equals(tipoLoja)) {
                count++;
            }
        }
        return (tipoLoja.equals("Cosmetico") || tipoLoja.equals("Vestuario") ||
                tipoLoja.equals("Bijuteria") || tipoLoja.equals("Informatica") ||
                tipoLoja.equals("Alimentacao")) ? count : -1;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica maisCara = null;
        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica informatica = (Informatica) loja;
                if (maisCara == null || informatica.getSeguroEletronicos() > maisCara.getSeguroEletronicos()) {
                    maisCara = informatica;
                }
            }
        }
        return maisCara;
    }
}