package rentcar.grails

class Cliente {

	String nome
	String email
	int telefone
	Endereco endereco 

	static embedded = ['endereco']

	static hasMany = [reservas: Reserva]

    static constraints = {
    }
}

class Endereco {

	String uf
	String cidade
	String bairro
	String logradouro
	int numero

}