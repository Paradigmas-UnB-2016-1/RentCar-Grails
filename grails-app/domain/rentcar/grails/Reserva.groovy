package rentcar.grails

class Reserva {

	Date dataInicio
	Date dataFim

	static belongsTo = [carro: Carro,
						cliente: Cliente]

    static constraints = {
    }
}
