package rentcar.grails

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.apache.commons.lang.builder.HashCodeBuilder

@ToString(cache=true, includeNames=true, includePackage=false)
class AdministradorFuncao implements Serializable {

	private static final long serialVersionUID = 1

	Administrador administrador
	Funcao funcao

	AdministradorFuncao(Administrador u, Funcao r) {
		this()
		administrador = u
		funcao = r
	}

	@Override
	boolean equals(other) {
		if (!(other instanceof AdministradorFuncao)) {
			return false
		}

		other.administrador?.id == administrador?.id && other.funcao?.id == funcao?.id
	}

	@Override
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (administrador) builder.append(administrador.id)
		if (funcao) builder.append(funcao.id)
		builder.toHashCode()
	}

	static AdministradorFuncao get(long administradorId, long funcaoId) {
		criteriaFor(administradorId, funcaoId).get()
	}

	static boolean exists(long administradorId, long funcaoId) {
		criteriaFor(administradorId, funcaoId).count()
	}

	private static DetachedCriteria criteriaFor(long administradorId, long funcaoId) {
		AdministradorFuncao.where {
			administrador == Administrador.load(administradorId) &&
			funcao == Funcao.load(funcaoId)
		}
	}

	static AdministradorFuncao create(Administrador administrador, Funcao funcao, boolean flush = false) {
		def instance = new AdministradorFuncao(administrador: administrador, funcao: funcao)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(Administrador u, Funcao r, boolean flush = false) {
		if (u == null || r == null) return false

		int rowCount = AdministradorFuncao.where { administrador == u && funcao == r }.deleteAll()

		if (flush) { AdministradorFuncao.withSession { it.flush() } }

		rowCount
	}

	static void removeAll(Administrador u, boolean flush = false) {
		if (u == null) return

		AdministradorFuncao.where { administrador == u }.deleteAll()

		if (flush) { AdministradorFuncao.withSession { it.flush() } }
	}

	static void removeAll(Funcao r, boolean flush = false) {
		if (r == null) return

		AdministradorFuncao.where { funcao == r }.deleteAll()

		if (flush) { AdministradorFuncao.withSession { it.flush() } }
	}

	static constraints = {
		funcao validator: { Funcao r, AdministradorFuncao ur ->
			if (ur.administrador == null || ur.administrador.id == null) return
			boolean existing = false
			AdministradorFuncao.withNewSession {
				existing = AdministradorFuncao.exists(ur.administrador.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		id composite: ['administrador', 'funcao']
		version false
	}
}
