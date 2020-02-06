package dao;

import java.sql.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import models.Event;
import models.EventDto;
import models.EventsDto;
import ninja.jpa.UnitOfWork;
import ninja.session.Session;

public class EventDao {
	@Inject
	Provider<EntityManager> entitiyManagerProvider;
	public static PolicyFactory sanitizer = Sanitizers.FORMATTING.and(Sanitizers.BLOCKS);

	@ElementCollection
	java.util.List<Event> events;

	@UnitOfWork

	public EventsDto getallevents() {
		EntityManager entityManager = entitiyManagerProvider.get();
		TypedQuery<Event> q = entityManager.createQuery("select * from public.events", Event.class);
		List<Event> events = q.getResultList();
		EventsDto eventsDto = new EventsDto();
		eventsDto.events = events;
		return eventsDto;
	}

	@Transactional
	public boolean postEvent(EventDto eventDto) {

		EntityManager entityManager = entitiyManagerProvider.get();
		String eventName = sanitizer.sanitize(eventDto.eventname);
		String eventVenue = sanitizer.sanitize(eventDto.eventvenue);
		// Date eventDate=sanitizer.sanitize(eventDto.eventdate);
		Event evemt = new Event();
		evemt.setEventname(eventName);
		evemt.setEventvenue(eventVenue);
		Date eventdate = new Date(System.currentTimeMillis());
		evemt.setEventdate(eventdate);
		entityManager.persist(evemt);
		return true;

	}
//	@Transactional
//	public boolean updatebook(@PathParam("event_id")long id) {
//		EntityManager entityManager=entitiyManagerProvider.get();
//		Query qupdateq=entityManager.createQuery("");
//	}

}
