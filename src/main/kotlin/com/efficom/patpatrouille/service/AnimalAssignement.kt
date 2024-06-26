package com.efficom.patpatrouille.service

import com.efficom.patpatrouille.domain.Animal
import com.efficom.patpatrouille.domain.Enclosure

interface AnimalAssignement {
    fun addAnimalToEnclosure(animal: Animal, enclosure: Enclosure)
    fun removeAnimalFromEnclosure(animal: Animal, enclosure: Enclosure)
}
