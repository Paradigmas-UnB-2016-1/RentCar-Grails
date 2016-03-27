package rentcar.grails

class Carro {

	String nome
	String modelo
	String marca
	int capacidadeDePessoas
	String corDoVeiculo
	String numeroDoChassi
	Double valorDoDia

    static constraints = {
    	nome nullable:false
    	modelo nullable:false
    	capacidadeDePessoas nullable:false
    	numeroDoChassi nullable:false, unique:true
    	valorDoDia nullable:false
    }
}
