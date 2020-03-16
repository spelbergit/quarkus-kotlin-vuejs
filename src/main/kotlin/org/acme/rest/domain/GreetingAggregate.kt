package org.acme.rest.domain

import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.modelling.command.AggregateRoot
import java.util.UUID

@AggregateRoot
class GreetingAggregate() {

    @AggregateIdentifier
    var id: UUID? = null

    @CommandHandler
    constructor(command: GreetCommand) : this() {
        println("@CommandHandler: command = $command")
        AggregateLifecycle.apply(GreetedEvent(command.id, command.message))
    }

    @EventSourcingHandler
    fun on(event: GreetedEvent) {
        println("@EventSourcingHandler: event = $event")
        id = event.id
    }

}