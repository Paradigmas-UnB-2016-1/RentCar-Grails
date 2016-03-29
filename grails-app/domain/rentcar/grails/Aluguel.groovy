package rentcar.grails

class Aluguel {

    Date dataInicio
	Date dataFim

	static belongsTo = [carro: Carro,
						cliente: Cliente,
						funcionario: Funcionario]

    static constraints = {
    }
}
