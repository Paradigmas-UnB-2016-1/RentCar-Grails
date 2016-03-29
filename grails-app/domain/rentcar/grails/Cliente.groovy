package rentcar.grails

class Cliente {

	String nome
	String email
	String telefone
	Endereco endereco 

	static embedded = ['endereco']

	static hasMany = [reservas: Reserva]

	static hasMany = [alugueis: Aluguel]

    static constraints = {
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

}