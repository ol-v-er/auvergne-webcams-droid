package fr.openium.auvergnewebcams.event

/**
 * Created by laura on 08/12/2017.
 */
class EventCameraDateUpdate : PublishEvents<Long>()

object Events {

    val eventCameraDateUpdate = EventCameraDateUpdate()

}