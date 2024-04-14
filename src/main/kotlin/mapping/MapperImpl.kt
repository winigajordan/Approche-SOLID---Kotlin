package org.example.mapping

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import org.example.entites.Employe
import org.example.mapping.dto.EmployeDto
import org.json.simple.JSONArray
import org.json.simple.JSONObject

class MapperImpl : Mapper{


    override fun mapEmployeToJSONObject(employe: Employe): JSONObject {
        var employeDtl = JSONObject()
        employeDtl.put("id", employe.id)
        employeDtl.put("nom", employe.nom)
        employeDtl.put("prenom", employe.prenom)
        employeDtl.put("salaire", employe.salaire)
        employeDtl.put("absence", employe.absence)
        employeDtl.put("retenu", employe.retenu)
        employeDtl.put("prime", employe.prime)
        employeDtl.put("salaireBrut", employe.salaireBrut)
        employeDtl.put("paiement", employe.paiement?.name)
        var employeObj  = JSONObject()
        employeObj.put("employe", employeDtl)
        return employeObj
    }

    override fun mapEmployeToJson(employeeList: JSONArray): String {
        var json: String = ""
        try {
            val ow: ObjectWriter = ObjectMapper().writer().withDefaultPrettyPrinter()

            val employeesDto = ArrayList<EmployeDto>()

            for (emp in employeeList) {
                var empJsonObject = emp as JSONObject
                empJsonObject = empJsonObject["employe"] as JSONObject
                employeesDto.add(EmployeDto(empJsonObject))
                //println(empJsonObject)
            }
            json = ow.writeValueAsString(employeesDto)
        } catch (e: JsonProcessingException) {
            e.printStackTrace()
        }
        return json
    }
}