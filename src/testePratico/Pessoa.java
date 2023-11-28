package testePratico;

import java.time.LocalDate;

public class Pessoa {
	public String Nome;
    public LocalDate dataNascimento;

    public Pessoa(String Nome, LocalDate dataNascimento){
        this.Nome = Nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome(){
        return Nome;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public void setNome(String Nome){
       this.Nome = Nome;
    }

    public void setDataNascimento(LocalDate dataNascimento){
       this.dataNascimento = dataNascimento;
    }
}
