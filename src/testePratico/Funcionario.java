package testePratico;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
	 public String funcao;
	 private BigDecimal salario;

	    
	    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
	        
	        super(nome, dataNascimento);
	        this.salario = salario;
	        this.funcao = funcao;
	    }

	    public String getFuncao(){
	        return funcao;
	    }

	    public BigDecimal getSalario(){
	        return salario;
	    }

	    public void setFuncao(String funcao){
	        this.funcao = funcao;
	    }

	    public void setSalario(BigDecimal salario){
	        this.salario = salario;
	    }
	    
	
}

