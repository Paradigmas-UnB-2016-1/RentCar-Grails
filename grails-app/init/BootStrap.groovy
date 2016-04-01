import rentcar.grails.*
 
class BootStrap {
 
    def springSecurityService
 
        def init = { servletContext ->
     
        def adminRole = new Funcao(authority: 'ROLE_ADMIN').save(flush: true)

        def usuario = new Administrador(username: 'admin', enabled: true, password: 'admin')
        usuario.save(flush: true)

        AdministradorFuncao.create usuario, adminRole, true
     
        }
 
    def destroy = {
    }
 
}