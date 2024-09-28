package Exception;

import Model.ErrorMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
    @Override
    public Response toResponse(DataNotFoundException e) {
        ErrorMessage error = new ErrorMessage(e.getMessage(),404,"description");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
    }
}
