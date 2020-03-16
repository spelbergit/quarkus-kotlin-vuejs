package org.acme.rest

import org.acme.rest.domain.GreetCommand
import org.acme.rest.domain.GreetedEvent
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.eventhandling.EventHandler
import java.util.UUID
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/greeting")
class GreetingResource {

    @Inject
    var commandGateway: CommandGateway? = null

    var greeting: String? = null

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        val commandGateway = this.commandGateway
        if (commandGateway != null) {
            val id: UUID = commandGateway.sendAndWait(GreetCommand(UUID.randomUUID(), "Hello World!"))
            println("@GET: command returned: id = ${id}")
            println("@GET: command handled: greeting = $greeting")
            return greeting.orEmpty()
        } else {
            return ""
        }
    }

    @EventHandler
    fun handle(greetedEvent: GreetedEvent) {
        println("@EventHandler: greetedEvent = $greetedEvent")
        greeting = greetedEvent.message
    }

}