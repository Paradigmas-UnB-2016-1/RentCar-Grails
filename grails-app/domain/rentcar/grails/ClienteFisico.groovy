package rentcar.grails

class ClienteFisico extends Cliente {

	String cpf
	int celular
	Date dataNascimento

    static constraints = {
    }
}