package org.example.repository

import org.json.simple.JSONArray
import org.json.simple.JSONObject

interface IRepository {
    fun getEmployeJson(): JSONArray
    fun saveJson(employe: JSONObject)
    fun strategy(): String
}