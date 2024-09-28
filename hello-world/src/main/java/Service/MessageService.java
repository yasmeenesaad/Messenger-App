package Service;

import Model.Message;
import database.DatabaseClass;
import Exception.DataNotFoundException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService {
    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(0L, new Message(1L, "hello jasmine", "Marwan"));
        messages.put(1L, new Message(2L, "hi marwan", "jasmine"));
        messages.put(2L, new Message(3L, "test message", "test user"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messages.values());
    }

    public Message getMessageById(Long id) {
        Message message = messages.get(id);
//        if (message == null) {
//            throw new DataNotFoundException("message with id: "+id +" not found");
//        }
        return message;
    }

    public Message addMessage(Message message) {
        message.setId((long) (messages.size() + 1));
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        messages.put(message.getId(), message);
        return message;
    }

    public Message deleteMessage(long id) {
        return messages.remove(id);
    }

    public List<Message> getMessageByYear(int year){
            List<Message> messagesforYear=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        for(Message message : messages.values())
        {
            calendar.setTime(message.getCreated());
            if (calendar.get(Calendar.YEAR)==year)
                messagesforYear.add(message);
        }
        return messagesforYear;
    }
        public List<Message> getMessagePaginated(int start, int count){
        ArrayList<Message> list=new ArrayList<>(messages.values());
        if(start+count>list.size()){
            return new ArrayList<Message>();
        }
        return list.subList(start,start+count);
    }

}


