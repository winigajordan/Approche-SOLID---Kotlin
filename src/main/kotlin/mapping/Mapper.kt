package org.example.mapping

import org.example.entites.Employe
import org.json.simple.JSONArray
import org.json.simple.JSONObject

interface Mapper {
    fun mapEmployeToJSONObject(employe: Employe): JSONObject
    fun mapEmployeToJson(employeeList: JSONArray): String
}