package com.efficom.patpatrouille.domain

import com.efficom.patpatrouille.domain.enums.EnclosureSizes

data class Enclosure(var id: Int, var name: String, var allowedSpecies: MutableList<Species>, var size: EnclosureSizes){
    var animals: MutableList<Animal> = mutableListOf()
}
