package com.efficom.patpatrouille.service

import com.efficom.patpatrouille.domain.Enclosure
import com.efficom.patpatrouille.domain.Visit
import java.time.LocalDate

class VisitManagerService {
    fun scheduleVisit(date: LocalDate, enclosureToVisit: MutableList<Enclosure>): Visit {
       return Visit(date, enclosureToVisit)
    }
}
