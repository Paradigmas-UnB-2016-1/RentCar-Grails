package rentcar.grails

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured("isAuthenticated()")
class CarroController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Carro.list(params), model:[carroCount: Carro.count()]
    }

    def show(Carro carro) {
        respond carro
    }

    def create() {
        respond new Carro(params)
    }

    @Transactional
    def save(Carro carro) {
        if (carro == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (carro.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond carro.errors, view:'create'
            return
        }

        carro.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'carro.label', default: 'Carro'), carro.id])
                redirect carro
            }
            '*' { respond carro, [status: CREATED] }
        }
    }

    def edit(Carro carro) {
        respond carro
    }

    @Transactional
    def update(Carro carro) {
        if (carro == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (carro.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond carro.errors, view:'edit'
            return
        }

        carro.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'carro.label', default: 'Carro'), carro.id])
                redirect carro
            }
            '*'{ respond carro, [status: OK] }
        }
    }

    @Transactional
    def delete(Carro carro) {

        if (carro == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        carro.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'carro.label', default: 'Carro'), carro.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'carro.label', default: 'Carro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
