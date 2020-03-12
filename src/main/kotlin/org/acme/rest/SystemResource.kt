package org.acme.rest

import java.util.Properties
import java.util.SortedMap
import java.util.TreeMap
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/system")
class SystemResource {

    @GET
    @Path("property")
    @Produces(MediaType.TEXT_PLAIN)
    fun property(name: String?) = if (name.isNullOrBlank()) { System.getProperty("hostname") } else null

    @GET
    @Path("properties")
    @Produces(MediaType.APPLICATION_JSON)
    fun properties(): Map<String, String> {
        val map = TreeMap<String, String>()
        System.getProperties().forEach {
            map.put(it.key as String, it.value as String)
        }
        return map
    }

}
