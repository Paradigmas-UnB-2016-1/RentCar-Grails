package rentcar.grails

class Carro {

	String nome
	String categoria
	String marca
	int capacidadeDePessoas
	String corDoVeiculo
	String numeroDoChassi
	Double valorDoDia

	static belongsTo = [funcionario: Funcionario]

    static constraints = {
    	nome nullable:false, blank:false
    	categoria inList: ["Economico","Compacto","Esportivo","Luxo","Pick up","SUV","Grande","Medio"]
    	capacidadeDePessoas min:1, max:8
    	corDoVeiculo nullable:false, blank:false, inList: ["Branco","Preto","Prata","Cinza","Azul","Vermelho",
    														"Amarelo","Laranja","Verde"]
    	numeroDoChassi nullable:false, unique:true
    	valorDoDia nullable:false
    }

    String toString(){
	  return nome
	} 
}
