package Exception;

import Model.ErrorMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable e) {
        ErrorMessage error = new ErrorMessage(e.getMessage(),500,"description");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
    }
}
