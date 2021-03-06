package rentcar.grails

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured("permitAll")
@Transactional(readOnly = true)

class ClienteFisicoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured("isAuthenticated()")
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ClienteFisico.list(params), model:[clienteFisicoCount: ClienteFisico.count()]
    }

    def show(ClienteFisico clienteFisico) {
        respond clienteFisico
    }

    def create() {
        respond new ClienteFisico(params)
    }

    @Transactional
    def save(ClienteFisico clienteFisico) {
        if (clienteFisico == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (clienteFisico.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond clienteFisico.errors, view:'create'
            return
        }

        clienteFisico.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'clienteFisico.label', default: 'ClienteFisico'), clienteFisico.id])
                redirect clienteFisico
            }
            '*' { respond clienteFisico, [status: CREATED] }
        }
    }

    def edit(ClienteFisico clienteFisico) {
        respond clienteFisico
    }

    @Transactional
    def update(ClienteFisico clienteFisico) {
        if (clienteFisico == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (clienteFisico.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond clienteFisico.errors, view:'edit'
            return
        }

        clienteFisico.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'clienteFisico.label', default: 'ClienteFisico'), clienteFisico.id])
                redirect clienteFisico
            }
            '*'{ respond clienteFisico, [status: OK] }
        }
    }

    @Transactional
    def delete(ClienteFisico clienteFisico) {

        if (clienteFisico == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        clienteFisico.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'clienteFisico.label', default: 'ClienteFisico'), clienteFisico.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'clienteFisico.label', default: 'ClienteFisico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
