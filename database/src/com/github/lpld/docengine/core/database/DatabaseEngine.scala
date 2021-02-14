package com.github.lpld.docengine.core.database

import zio.{Task, ZIO}

/** */
class DatabaseEngine(
  eventsQueue: IncomingEventsQueue,
) {

  def start: Task[Nothing] =
    eventsQueue
      .nextEvent
      .tap(handleIncomingEvent)
      .forever

  def handleIncomingEvent(event: Event[IncomingData]): Task[Unit] = ???
}

trait DatabaseEventListener {

}



