package aprendendopoo;

import java.util.Calendar;
import java.util.Date;

public class Funcionario {

    private String nome;
    private Date dataAdmissao;
    private float valorHora, horasTrabalhadas;

    public long calcularTempoEmpresa() {
        Calendar dataAtual = Calendar.getInstance();
        Calendar dataAdmissaoCal = Calendar.getInstance();
        dataAdmissaoCal.setTime(this.dataAdmissao);

        long anoAtual = dataAtual.get(Calendar.YEAR);
        long anoAdmissao = dataAdmissaoCal.get(Calendar.YEAR);

        long anosTrabalhados = anoAtual - anoAdmissao;

        // Verifica se a data de admissão ainda não passou deste ano (mês/dia)
        if (dataAtual.get(Calendar.DAY_OF_YEAR) < dataAdmissaoCal.get(Calendar.DAY_OF_YEAR)) {
            anosTrabalhados--;
        }

        return anosTrabalhados;
    }

    public float calcularSalario() {

        float salario = this.valorHora * this.horasTrabalhadas;
        long temEmpresa = calcularTempoEmpresa();

        float dezporcento = salario * (10/100);
        float cincoporcento = salario * (5/100);

        if (temEmpresa >= 10) {
            salario += dezporcento; // Acrescenta 10% ao salário
        } else if (temEmpresa >= 5) {
            salario += cincoporcento;  // Acrescenta 5% ao salário
        }
        return salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

}
