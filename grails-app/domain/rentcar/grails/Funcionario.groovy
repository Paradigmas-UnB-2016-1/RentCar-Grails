package rentcar.grails

class Funcionario {

	String nome
	String endereco
	String email
	//Date dataNascimento
	Integer idade
	//String cargo

	//static hasMany = [carro: Carro]
	
	String toString(){
	  return nome
	} 
    
    static constraints = {
		nome nullable:false, blank:false
    	endereco nullable:false, blank:false
    	email email:true, unique:true
		idade size: 18..150	
    }

}