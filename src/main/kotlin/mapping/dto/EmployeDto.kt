package org.example.mapping.dto

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.json.simple.JSONObject

@Data
@AllArgsConstructor
@NoArgsConstructor

class EmployeDto(
    var id: Long = 0 ,
    var nom: String = "",
    var prenom: String = "",
    var nbreAbsence: Long = 0
) {
    constructor(emp: JSONObject) : this(
        id = emp["id"] as Long,
        nom = emp["nom"] as String,
        prenom = emp["prenom"] as String,
        nbreAbsence = (emp["absence"] as Long) ?: 0
    )
}