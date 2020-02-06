
package controllers;

import com.google.inject.Inject;

import dao.EventDao;
import models.EventDto;
import models.EventsDto;
import ninja.Context;
import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;

public class EventControllerImpl implements EventController {
	@Inject
	EventDao eventDao;

	public Result eventShow(@PathParam("event_id") Long id) {
		EventsDto event = null;
		if (id != null) {
			event = eventDao.getallevents();
			return Results.ok().json().render(event);
		}
		return Results.unauthorized().json().render(eventDao.getallevents());
	}

	public Result neweventPost(Context context, EventDto eventDto) {
		eventDao.postEvent(eventDto);
		context.getFlashScope().success("new event created");
		return Results.redirect("/newevents");
	}

	public Result newEvent(EventDto eventDto) {

		boolean succeeded = eventDao.postEvent(eventDto);

		if (!succeeded) {
			return Results.notFound();
		} else {
			return Results.json();
		}

	}
}
