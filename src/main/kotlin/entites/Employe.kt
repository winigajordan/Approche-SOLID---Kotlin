package org.example.entites

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Employe(builder : EmployeBuilder) {
    var id: Long? = null
    var nom: String? = null
    var prenom: String? = null
    var salaire: Double? = null
    var absence: Long? = null
    var retenu: Double? = null
    var prime: Double? = null
    var salaireBrut: Double? = null
    var paiement: ModePaiement? = null

    init {
        this.id = builder.id
        this.nom = builder.nom
        this.prenom = builder.prenom
        this.salaire = builder.salaire
        this.absence = builder.absence
        this.retenu = builder.retenu
        this.prime = builder.prime
        this.salaireBrut = builder.salaireBrut
        this.paiement = builder.paiement
    }


    class EmployeBuilder {
        var id: Long? = null
        var nom: String? = null
        var prenom: String? = null
        var salaire: Double? = null
        var absence: Long? = null
        var retenu: Double? = null
        var prime: Double? = null
        var salaireBrut: Double? = null
        var paiement: ModePaiement? = null

        fun id(id: Long) = apply { this.id = id }
        fun nom(nom: String) = apply { this.nom = nom }
        fun prenom(prenom: String) = apply { this.prenom = prenom }
        fun salaire(salaire: Double) = apply { this.salaire = salaire }
        fun absence(absence: Long) = apply { this.absence = absence }
        fun retenu(retenu: Double) = apply { this.retenu = retenu }
        fun prime(prime: Double) = apply { this.prime = prime }
        fun salaireBrut(salaireBrut: Double) = apply { this.salaireBrut = salaireBrut }
        fun paiement(paiement: ModePaiement) = apply { this.paiement = paiement }

        fun build() = Employe(this)
    }

}
