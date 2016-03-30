package rentcar.grails

class ClienteJuridico extends Cliente {

	String cnpj

    static constraints = {
    	cnpj nullable:false, blank: false, maxSize: 14
    }

    String toString(){
	  return super.nome
	}
}
