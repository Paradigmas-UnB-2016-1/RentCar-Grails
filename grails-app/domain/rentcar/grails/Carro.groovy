package rentcar.grails

class Carro {

	String nome
	String categoria
	String marca
	int capacidadeDePessoas
	String corDoVeiculo
	String numeroDoChassi
	Double valorDiaria

	static belongsTo = [funcionario: Funcionario]

	static hasMany = [reservas: Reserva, alugueis: Aluguel]

    static constraints = {
    	nome nullable:false, blank:false
    	categoria inList: ["Economico","Compacto","Esportivo","Luxo","Pick up","SUV","Grande","Medio"]
    	capacidadeDePessoas nullable:false
    	corDoVeiculo nullable:false, blank:false, inList: ["Branco","Preto","Prata","Cinza","Azul","Vermelho",
    														"Amarelo","Laranja","Verde"]
    	numeroDoChassi nullable:false, unique:true
    	valorDiaria nullable:false, scale: 2
    }

    String toString(){
	  return nome + " " + corDoVeiculo
	} 
}
