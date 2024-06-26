package com.efficom.patpatrouille.service

import com.efficom.patpatrouille.domain.Animal
import com.efficom.patpatrouille.domain.Enclosure

class AnimalAssignementService: AnimalAssignement {
    override fun addAnimalToEnclosure(animal: Animal, enclosure: Enclosure) {
        if (enclosureCanHostAnimal(enclosure, animal)) {
            enclosure.animals.add(animal)
        }
    }

    override fun removeAnimalFromEnclosure(animal: Animal, enclosure: Enclosure) {
        enclosure.animals.remove(animal)
    }

    private fun enclosureCanHostAnimal(
        enclosure: Enclosure,
        animal: Animal
    ) = enclosure.allowedSpecies.contains(animal.specie) && enclosure.animals.size < enclosure.size.maxAnimals
}
