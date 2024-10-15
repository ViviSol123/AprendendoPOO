package aprendendopoo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AprendendoPOO {
   
    public static void main(String[] args) {
        
        Funcionario func1 = new  Funcionario();
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Insira o nome do funcionário:");
        func1.setNome(teclado.next());
        
        System.out.println("Informe a data de admissão do funcionário(dd/MM/yyyy):");
        String aux = teclado.next(); // recebe a data do usuario
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try { // se der erro na conversão da data ivalida
            Date data = df.parse(aux); //converte o texto em data
        } catch (ParseException ex) {
            System.out.println("Data Inválida");
        }
        
        System.out.print("Informe o valor da hora trabalhada: ");
        func1.setValorHora(teclado.nextFloat());

       // Exibe os resultados
        System.out.println("\nNome do funcionário: " + func1.getNome());
        System.out.println("Tempo de empresa: " + func1.calcularTempoEmpresa() + " anos");
        System.out.println("Salário a receber: R$ " + String.format("%.2f", func1.calcularSalario()));

    }
    
}
