package rentcar.grails

class Funcionario {
	
	String nome
	Endereco endereco
	String email
	String senha
	Date dataNascimento
	Integer idade
	String celular

	static embedded = ['endereco']

	static hasMany = [carros: Carro, alugueis: Aluguel]
    
    static constraints = {
		nome nullable:false, blank:false
    	endereco nullable:false, blank:false
    	email email:true, unique:true
		idade size: 18..150	
		senha password:true
		celular (phoneNumber: [strict: true])
    }

    String toString() {
    	return nome
    }
}