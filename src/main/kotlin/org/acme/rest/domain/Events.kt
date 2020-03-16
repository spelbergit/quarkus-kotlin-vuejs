package org.acme.rest.domain

import java.util.UUID

data class GreetedEvent(val id: UUID, val message: String)