package br.com.fiap.techchallenge.application.core.domain

data class Client(var id: Int? = null, var name: String, var cpf: String, var email: String, var phone: String) {
    fun isValid(): Boolean {
        return name.isNotBlank()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Client

        if (id != other.id) return false
        if (name != other.name) return false
        if (cpf != other.cpf) return false
        if (email != other.email) return false
        return phone == other.phone
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + cpf.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + phone.hashCode()
        return result
    }

    override fun toString(): String {
        return "Client(id=$id, name='$name', cpf='$cpf', email='$email', phone='$phone')"
    }


}


