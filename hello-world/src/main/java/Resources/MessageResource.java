package Resources;

import Model.Link;
import Model.Message;
import Model.Profile;
import Service.MessageService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Path("messages")
@Consumes(MediaType.APPLICATION_JSON) //how it accepts the body
@Produces(value={MediaType.APPLICATION_JSON,MediaType.TEXT_HTML}) // how it sends the response body

public class MessageResource {

    MessageService messageService = new MessageService();
    @GET
    public List<Message> getMessage() {
        return messageService.getAllMessages();
    }
    @GET
    @Path("/{id}")
    public Message getMessage(@PathParam("id") Long id,@Context UriInfo uriInfo) {

        Message message= messageService.getMessageById(id);
        getUriForMessage(uriInfo, message);
        getUriForProfile(uriInfo, message);
        getUriForComments(uriInfo, message);

        return message;

    }

    private void getUriForComments(UriInfo uriInfo, Message message) {
        String uri= uriInfo.getBaseUriBuilder()
                .path(MessageResource.class)
                .path(MessageResource.class, "getCommentResource")
                .path(CommentResource.class)
                .resolveTemplate("messageId", message.getId())
                .build()
                .toString();
        message.addLink(uri,"self");
    }

    private static void getUriForMessage(UriInfo uriInfo, Message message) {
        String uri= uriInfo.getBaseUriBuilder()
                .path(MessageResource.class)
                .path(Long.toString(message.getId()))
                .build()
                .toString();
        message.addLink(uri,"self");
    }
    private static void getUriForProfile(UriInfo uriInfo, Message message) {
        String uri= uriInfo.getBaseUriBuilder()
                .path(ProfileResource.class)
                .path(message.getAuthor())
                .build()
                .toString();
        message.addLink(uri,"self");
    }

    @POST
    public Response addMessage(Message message , @Context UriInfo uriInfo) throws URISyntaxException {
        uriInfo.getAbsolutePath();
        Message newMessage = messageService.addMessage(message);
        String newId= String.valueOf(newMessage.getId());
        URI uri= uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                .entity(newMessage)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Message updateMessage(@PathParam("id")Long id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMessage(@PathParam("id")Long id) {
        System.out.println(messageService.getMessageById(id).getAuthor());
        messageService.deleteMessage(id);
        System.out.println("Message deleted");
        return Response.ok().build();
    }
    @GET
    @Path("/byYear")
    public List<Message> getMessageByYear(@QueryParam("year") int year) {
        return messageService.getMessageByYear(year);
    }

    @GET
    @Path("/{start}/{count}")
    public List<Message> getMessagePaginated(@PathParam("start") int start, @PathParam("count") int count) {
        return messageService.getMessagePaginated(start, count);
    }


    @Path("/{messageId}/comments")
    public CommentResource getCommentResource(@PathParam("messageId") Long messageId) {

        return new CommentResource();
    }


}

