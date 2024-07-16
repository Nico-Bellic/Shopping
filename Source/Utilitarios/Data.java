import java.time.LocalDate;
public class Data {
    private int dia;
    private int mes;
    private int ano;
  
    
    public Data(int dia, int mes, int ano) {
        if (validaData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida. Alterando para 1/1/2000.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int compareTo(Data dataValidade) {
        if (this.ano != dataValidade.ano) {
            return Integer.compare(this.ano, dataValidade.ano);
        }
        if (this.mes != dataValidade.mes) {
            return Integer.compare(this.mes, dataValidade.mes);
        }
        return Integer.compare(this.dia, dataValidade.dia);
    }
    
    public static Data dataAtual() {
        LocalDate hoje = LocalDate.now();
        return new Data(hoje.getDayOfMonth(), hoje.getMonthValue(), hoje.getYear());
    }
    
    public String toString() {
        return dia + "/n" + mes + "/n" + ano;
    }

    public boolean verificaAnoBissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    private boolean validaData(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12) {
            return false;
        }

        if (dia < 1 || dia > diasNoMes(mes, ano)) {
            return false;
        }

        return true;
    }

    private int diasNoMes(int mes, int ano) {
        switch (mes) {
            case 2:                       // true   false
                return verificaAnoBissexto() ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
}
