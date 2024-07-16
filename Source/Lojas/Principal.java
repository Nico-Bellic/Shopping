import java.util.Scanner;

public class Principal {

    private static Loja criarLoja(Scanner scanner) {
        System.out.println("Digite o nome da loja: ");
        String nome = scanner.next();

        System.out.println("Digite a quantidade de funcionários da loja: ");
        int quantidadeFuncionarios = scanner.nextInt();

        System.out.println("Digite o salário base dos funcionários da loja: ");
        double salarioBase = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite o nome da rua do endereço da loja: ");
        String rua = scanner.nextLine();

        System.out.println("Digite a cidade do endereço da loja: ");
        String cidade = scanner.nextLine();

        System.out.println("Digite o estado do endereço da loja: ");
        String estado = scanner.nextLine();

        System.out.println("Digite o país do endereço da loja: ");
        String pais = scanner.nextLine();

        System.out.println("Digite o CEP do endereço da loja: ");
        String cep = scanner.nextLine();

        System.out.println("Digite o número do endereço da loja: ");
        String numero = scanner.nextLine();

        System.out.println("Digite o complemento do endereço da loja: ");
        String complemento = scanner.nextLine();

        Endereco endereco = new Endereco(rua, cidade, estado, pais, cep, numero, complemento);

        System.out.println("Digite a data de fundação da loja (no formato dia/mês/ano): ");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int ano = scanner.nextInt();
        Data dataFundacao = new Data(dia, mes, ano);

        System.out.println("Digite a quantidade máxima de produtos da loja: ");
        int quantidadeMaximaProdutos = scanner.nextInt();

        System.out.println("Selecione o tipo de loja (1: Cosmetico, 2: Vestuario, 3: Bijuteria, 4: Informatica, 5: Alimentacao): ");
        int tipoLoja = scanner.nextInt();

        switch (tipoLoja) {
            case 1:
                System.out.println("Digite a taxa de comercialização: ");
                double taxaComercializacao = scanner.nextDouble();
                return new Cosmetico(nome, quantidadeFuncionarios, salarioBase, endereco, dataFundacao, taxaComercializacao, quantidadeMaximaProdutos);
            case 2:
                System.out.println("A loja vende produtos importados? (sim/nao): ");
                boolean produtosImportados = scanner.nextBoolean();
                return new Vestuario(nome, quantidadeFuncionarios, salarioBase, endereco, dataFundacao, produtosImportados, quantidadeMaximaProdutos);
            case 3:
                System.out.println("Digite a meta de vendas: ");
                double metaVendas = scanner.nextDouble();
                return new Bijuteria(nome, quantidadeFuncionarios, salarioBase, endereco, dataFundacao, metaVendas, quantidadeMaximaProdutos);
            case 4:
                System.out.println("Digite o valor do seguro de eletrônicos: ");
                double seguroEletronicos = scanner.nextDouble();
                return new Informatica(nome, quantidadeFuncionarios, salarioBase, endereco, dataFundacao, seguroEletronicos, quantidadeMaximaProdutos);
            case 5:
                System.out.println("Digite a data do alvará (no formato dia/mês/ano): ");
                int diaAlvara = scanner.nextInt();
                int mesAlvara = scanner.nextInt();
                int anoAlvara = scanner.nextInt();
                Data dataAlvara = new Data(diaAlvara, mesAlvara, anoAlvara);
                return new Alimentacao(nome, quantidadeFuncionarios, salarioBase, endereco, dataFundacao, dataAlvara, quantidadeMaximaProdutos);
            default:
                System.out.println("Tipo de loja inválido.");
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do shopping: ");
        String nomeShopping = scanner.nextLine();

        System.out.println("Digite o nome da rua do endereço do shopping: ");
        String ruaShopping = scanner.nextLine();

        System.out.println("Digite a cidade do endereço do shopping: ");
        String cidadeShopping = scanner.nextLine();

        System.out.println("Digite o estado do endereço do shopping: ");
        String estadoShopping = scanner.nextLine();

        System.out.println("Digite o país do endereço do shopping: ");
        String paisShopping = scanner.nextLine();

        System.out.println("Digite o CEP do endereço do shopping: ");
        String cepShopping = scanner.nextLine();

        System.out.println("Digite o número do endereço do shopping: ");
        String numeroShopping = scanner.nextLine();

        System.out.println("Digite o complemento do endereço do shopping: ");
        String complementoShopping = scanner.nextLine();

        Endereco enderecoShopping = new Endereco(ruaShopping, cidadeShopping, estadoShopping, paisShopping, cepShopping, numeroShopping, complementoShopping);

        System.out.println("Digite a quantidade máxima de lojas no shopping: ");
        int quantidadeMaximaLojas = scanner.nextInt();

        Shopping shopping = new Shopping(nomeShopping, enderecoShopping, quantidadeMaximaLojas);

        for (int i = 0; i < quantidadeMaximaLojas; i++) {
            System.out.println("Adicionar nova loja ao shopping? (sim/nao): ");
            String resposta = scanner.next();

            if (resposta.equalsIgnoreCase("sim")) {
                Loja loja = criarLoja(scanner);
                if (loja != null) {
                    shopping.insereLoja(loja);
                }
            } else {
                break;
            }
        }

        System.out.println(shopping);

        System.out.println("Quantidade de lojas de Cosmético: " + shopping.quantidadeLojasPorTipo("Cosmetico"));
        System.out.println("Loja de Informática com seguro mais caro: " + shopping.lojaSeguroMaisCaro());

        scanner.close();
    }
}
