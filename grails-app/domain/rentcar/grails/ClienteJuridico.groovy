package rentcar.grails

class ClienteJuridico extends Cliente {

	String cnpj

    static constraints = {
    }

    String toString(){
	  return super.nome
	}
}
