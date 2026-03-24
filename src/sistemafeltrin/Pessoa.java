/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author u07994189199
 */
public class Pessoa {
    
    private String nome;
    private int idade;
    
    
    public Pessoa(){ 
        
        nome = "";
        idade = 0;        
        
    }
    
    public Pessoa (String nome, int idade){
       this.nome = nome;
       this.idade = idade;
        }
    
public void aniversario(){
        setIdade(getIdade() + 1);
}
  
public void aniversario(int idade){
    this.setIdade(idade);
}

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.aniversario();
        pessoa.setNome("marcos");
        System.out.println("nome: "+pessoa.getNome());
        System.out.println("idade: "+pessoa.getIdade());    
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
//ctrl - shift- seta para baixo = duplica
// comando sout =   System.out.printIn
//sobreeescrita o filho cria um metodo 
//a classe herda de outra classe... ela herda tudo ?...SIM...os construtores não são herdados, não todos.