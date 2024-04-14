package org.example

import org.example.entites.Employe
import org.example.entites.ModePaiement
import org.example.entites.ModeSave
import org.example.mapping.MapperImpl
import org.example.service.EmployeService

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {


    //val employeService = EmployeService()
    val employeService = EmployeService.getInstance(MapperImpl())


    //implementation du design patern builder
   val employe = Employe.EmployeBuilder()
        .id(1)
        .nom("ISM")
        .prenom("Batiment ingenieurs")
        .salaire(2000.0)
        .absence(2)
        .retenu(100.0)
        .prime(300.0)
        .salaireBrut(2200.0)
        .paiement(ModePaiement.Virement)
        .build()

    //affichage des données
    println(employeService.getEmployeJson())

    //enregistrement des données
    //employeService.saveEmploye2(employe, ModeSave.JSON )

    //test choix du mode de sauvegarde
    //println(employeService.testMode(ModeSave.DB))




}


