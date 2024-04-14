package org.example.repository

import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.text.ParseException

class EmployeJsonRepository private  constructor() : IRepository {

    companion object {
        private var instance: EmployeJsonRepository? = null
        fun getInstance(): EmployeJsonRepository {
            if (instance == null) {
                instance = EmployeJsonRepository()
            }
            return instance!!
        }
    }


    private val FILENAME = "data/data.json"

    override fun getEmployeJson(): JSONArray {
        var employeeList: JSONArray = JSONArray()
        val jsonParser = JSONParser()
        try {
            FileReader(FILENAME).use { reader ->
                val obj = jsonParser.parse(reader)
                employeeList = obj as JSONArray
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return employeeList
    }

    override  fun saveJson(employe: JSONObject) {
        val employeeList = getEmployeJson()
        employeeList.add(employe)
        //R2 : Persitence
        try {
            FileWriter(FILENAME).use { file ->
                file.write(employeeList.toJSONString()!!)
                file.flush()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun strategy(): String {
        return "\n Json Repository"
    }
}