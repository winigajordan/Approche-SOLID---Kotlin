package org.example.service

import org.example.entites.Employe
import org.example.entites.ModeSave
import org.example.mapping.Mapper
import org.example.repository.EmployeDbRepository
import org.example.repository.EmployeJsonRepository
import org.example.repository.IRepository

class EmployeService private constructor( var mapper: Mapper )  {

    //Au cas ou on ne veut pas faire d'injection de dépendance
    //lateinit var mapper : Mapper

    //Singleton
    companion object {
        private var instance: EmployeService? = null
        fun getInstance(mapper: Mapper): EmployeService {
            if (instance == null) {
                instance = EmployeService(mapper)
                instance!!.mapper = mapper
            }
            return instance!!
        }
    }

    //Vérification du mode de sauvegarde
    fun checkMode(mode: ModeSave): IRepository {
        return when (mode) {
            ModeSave.DB-> EmployeDbRepository.getInstance()
            ModeSave.JSON-> EmployeJsonRepository.getInstance()
        }
    }

    fun testMode(mode: ModeSave): String {
        return checkMode(mode).strategy()
    }

    //enregistrement des données
    fun saveEmploye2(employe: Employe, mode: ModeSave){
        val maJsonObject = mapper.mapEmployeToJSONObject(employe)
        checkMode(mode).saveJson(maJsonObject)
    }

    //test affichage des données
    private val employeRepository = EmployeJsonRepository.getInstance()
   fun getEmployeJson (): String {
        return mapper.mapEmployeToJson(employeRepository.getEmployeJson())
    }


}