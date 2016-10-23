
package org.learn.resource;

import org.learn.model.Student;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;


@Path("/student")
public class StudentResource {

    private static final String text = "Message from Server :\n%s";

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public Response registerStudent() {
        String response = String.format(text, new Date());
        return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
    }

    @GET
    @Path("/validate")
    public Response validaStudent(
            @Size(min = 2, max = 25, message = "firstName Length should be between 2 and 25 character")
            @QueryParam("firstName") String firstName,

            @Size(min = 2, max = 25, message = "lastName Length should be between 2 and 25 character")
            @QueryParam("lastName") String lastName,

            @Min(value = 15, message = "age should not be less that 15")
            @QueryParam("age")
                    String age) throws ValidationException {

        String student = String.format("firstName: %s, lastName: %s, age: %s", firstName, lastName, age);
        String response = String.format(text, student);
        return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
    }

    @POST
    @Path("/register")
    public Response registerStudent(
            @Valid Student student) throws ValidationException {

        String response = String.format(text, student);
        return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
    }
}
