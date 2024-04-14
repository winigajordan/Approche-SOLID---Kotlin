package org.example.repository

import org.json.simple.JSONArray
import org.json.simple.JSONObject

class EmployeDbRepository private constructor(): IRepository {

    companion object {
        private var instance: EmployeDbRepository? = null

        fun getInstance(): EmployeDbRepository {
            if (instance == null) {
                instance = EmployeDbRepository()
            }
            return instance!!
        }
    }

    override fun getEmployeJson(): JSONArray {
        return JSONArray()
    }

    override fun saveJson(employe: JSONObject) {
        println("Employe saved in db")
    }

    override fun strategy(): String {
        return "\n DB Repository"
    }
}