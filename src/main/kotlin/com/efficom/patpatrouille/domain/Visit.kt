package com.efficom.patpatrouille.domain

import java.time.LocalDate
import java.time.LocalTime

class Visit(var date: LocalDate, enclosureToVisit: MutableList<Enclosure>) {
    var id: Int = 0
    var animalSeen: MutableList<Animal> = mutableListOf()
    var enclosureToVisit: MutableList<Enclosure> = mutableListOf()
    lateinit var startTime: LocalTime
    lateinit var endTime: LocalTime
}
