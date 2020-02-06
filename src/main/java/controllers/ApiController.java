
package controllers;

import com.google.inject.Inject;

import dao.EventDao;
import models.EventDto;
import models.EventsDto;
import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;

public class ApiController {
	@Inject
	EventDao eventDao;

	public Result getEventsJson() {
		EventsDto eventsDto = eventDao.getallevents();
		return Results.json().render(eventsDto);
	}

	public Result newEvent(EventDto eventDto) {

		System.out.println("sdf" + eventDto);
		System.out.println("egrbhnt" + eventDto.eventname);
		System.out.println("bghtntsfv" + eventDto.eventvenue);
		boolean succeeded = eventDao.postEvent(eventDto);

		if (!succeeded) {
			return Results.notFound();
		} else {
			return Results.json();
		}

	}
	
	public Result updateEvent(@PathParam("event_id") long id) {
return Results.noContent();		
	}
	
/*    public Result updataBookJson(@PathParam ("username") String username ,@PathParam ("id") Long id, @PathParam("title") String title, @PathParam ("authorName") String authorName) {
    	boolean success =bookTo.updateBookId(username, id, title, authorName);
    	if(success) {
    		Book book = bookTo.getBook(id);
    		return Results.json().jsonView(View.Public.class).render(book);
    	}else {
    		return Results.json().render("Not Updated");
    	}
    }*/

}
