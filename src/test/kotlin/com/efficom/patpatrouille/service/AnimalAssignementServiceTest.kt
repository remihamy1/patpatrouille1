package com.efficom.patpatrouille.service

import com.efficom.patpatrouille.domain.Animal
import com.efficom.patpatrouille.domain.Enclosure
import com.efficom.patpatrouille.domain.enums.EnclosureSizes
import com.efficom.patpatrouille.domain.Species
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AnimalAssignementServiceTest {
    lateinit var animalAssignementService: AnimalAssignementService
    lateinit var fullEnclosureOfFeline: Enclosure
    @BeforeEach
    fun setUp() {
        fullEnclosureOfFeline = Enclosure(1, "Enclos des lions", mutableListOf(Species.FELINE), EnclosureSizes.SMALL)
        fillEnclosure(fullEnclosureOfFeline)
        animalAssignementService = AnimalAssignementService()

    }
    @Test
    fun `Quand j'ajoute un lion dans un petit enclos vide, le lion est bien ajouté à l'enclos`(){
        // Given
        val lion = Animal(1, "Lion", Species.FELINE)
        val enclosure = Enclosure(1, "Enclos 1", mutableListOf(Species.FELINE), EnclosureSizes.SMALL)

        // When
        animalAssignementService.addAnimalToEnclosure(lion, enclosure)

        // Then
        assertEquals(1, enclosure.animals.size)
        assertEquals(lion, enclosure.animals[0])
    }
    @Test
    fun `Quand j'ajoute un lion à un enclos plein, je reçois une erreur`(){
        // Given
        val lion = Animal(1, "Lion", Species.FELINE)

        fullEnclosureOfFeline.animals.add(Animal(2, "Lion", Species.FELINE))

        // When
        val exception = assertThrows(IllegalArgumentException::class.java) {
            animalAssignementService.addAnimalToEnclosure(lion, fullEnclosureOfFeline)
        }

        // Then
        assertEquals("L'enclos est plein", exception.message)
    }

    private fun fillEnclosure(enclosure: Enclosure) {
        for (i in 1..enclosure.size.maxAnimals) {
            val lion = Animal(i, "Lion $i", Species.FELINE)
            animalAssignementService.addAnimalToEnclosure(lion, enclosure)
        }
    }
}
