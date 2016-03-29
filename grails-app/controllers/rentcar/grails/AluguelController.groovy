package rentcar.grails

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AluguelController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Aluguel.list(params), model:[aluguelCount: Aluguel.count()]
    }

    def show(Aluguel aluguel) {
        respond aluguel
    }

    def create() {
        respond new Aluguel(params)
    }

    @Transactional
    def save(Aluguel aluguel) {
        if (aluguel == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (aluguel.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond aluguel.errors, view:'create'
            return
        }

        aluguel.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'aluguel.label', default: 'Aluguel'), aluguel.id])
                redirect aluguel
            }
            '*' { respond aluguel, [status: CREATED] }
        }
    }

    def edit(Aluguel aluguel) {
        respond aluguel
    }

    @Transactional
    def update(Aluguel aluguel) {
        if (aluguel == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (aluguel.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond aluguel.errors, view:'edit'
            return
        }

        aluguel.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'aluguel.label', default: 'Aluguel'), aluguel.id])
                redirect aluguel
            }
            '*'{ respond aluguel, [status: OK] }
        }
    }

    @Transactional
    def delete(Aluguel aluguel) {

        if (aluguel == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        aluguel.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'aluguel.label', default: 'Aluguel'), aluguel.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'aluguel.label', default: 'Aluguel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
