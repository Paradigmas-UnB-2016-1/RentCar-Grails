package rentcar.grails

class Cliente {

	String nome
	String email
	String telefone
	Endereco endereco 

	static embedded = ['endereco']

	static hasMany = [reservas: Reserva, alugueis: Aluguel]

    static constraints = {
    	nome nullable:false, blank:false
    	email email:true
    	telefone(phoneNumber: [strict: true])
    }
}

class Endereco {

	String uf
	String cidade
	String bairro
	String logradouro
	int numero
	
	static constraints = {
    	uf nullable:false, blank:false
    	cidade nullable:false, blank:false	
    }
}