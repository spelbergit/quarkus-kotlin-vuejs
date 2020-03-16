package org.acme.rest.domain

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.UUID

data class GreetCommand(@TargetAggregateIdentifier val id: UUID, val message: String)
