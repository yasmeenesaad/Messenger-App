package Resources;

import Model.Comment;
import Service.CommentService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON) //how it accepts the body
@Produces(value={MediaType.APPLICATION_JSON,MediaType.TEXT_HTML}) // how it sends the response body

public class CommentResource {

    private CommentService commentService=new CommentService();
//    @GET
//    public String test() {
//        return "Hello World";
//    }
//    @GET
//    @Path("/{commentId}")
//    public String test(@PathParam("messageId") String messageId,  @PathParam("commentId") String commentId) {
//        return "Hello World comment id " + commentId +" Message id :" + messageId;
//    }

@GET
    public List<Comment> getComments(@PathParam("messageId") Long messageId) {
        return commentService.getCommentList(messageId);
}
@GET
@Path("/{commentId}")
    public Comment getComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId) {
        return commentService.getComment(messageId, commentId);
}
@POST
    public Comment addComment(@PathParam("messageId") Long messageId, Comment comment) {
    return commentService.addComment(messageId, comment);
}
@PUT
@Path("/{commentId}")
    public Comment updateComment(@PathParam("messageId") Long messageId,@PathParam("commentId") Long commentId ,Comment comment) {
    comment.setId(commentId);
    return commentService.updateComment(messageId, comment);
}
}
