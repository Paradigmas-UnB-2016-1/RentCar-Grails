package rentcar.grails

class ClienteFisico extends Cliente {

	String cpf
	int celular
	Date dataNascimento

    static constraints = {
    	cpf nullable:false, blank: false, maxSize: 11
    	dataNascimento nullable:false
    }

    String toString(){
	  return super.nome
	}
}
