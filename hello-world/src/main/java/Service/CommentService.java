package Service;

import Model.Comment;
import Model.Message;
import database.DatabaseClass;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentService {
    Map<Long, Message> messages = DatabaseClass.getMessages();
    public CommentService(){
    }
public List<Comment> getCommentList(Long messageId){
        Message message = messages.get(messageId);
        if(message == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
Map<Long,Comment> comments=messages.get(messageId).getComments();
return new ArrayList<>(comments.values());
}
public Comment getComment(Long messageId,Long commentId){
    Map<Long,Comment> comments=messages.get(messageId).getComments();
        return comments.get(commentId);
}
public Comment addComment(Long messageId,Comment comment){
    Map<Long,Comment> comments=messages.get(messageId).getComments();
    comment.setId((long) (comments.size()+1));
    comments.put(comment.getId(),comment);
    return comment;
}
public Comment updateComment(Long messageId,Comment comment){
        Map<Long,Comment> comments=messages.get(messageId).getComments();
        comments.put(comment.getId(),comment);
        return comment;
}
public void deleteComment(Long messageId,Long commentId){
        Map<Long,Comment> comments=messages.get(messageId).getComments();
        comments.remove(commentId);
}

}
