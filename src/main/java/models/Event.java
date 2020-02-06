/**
 * Copyright (C) 2012-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="event_id")
	public Long eventid;

	@Column(name="event_name")
	public String eventname;

	@Column(name="event_venue")
	public String eventvenue;

	@Column(name="event_date")
	public java.sql.Date eventdate;

	public Event(Long eventid, String eventname, String eventvenue, java.sql.Date eventdate) {
		super();
		this.eventid = eventid;
		this.eventname = eventname;
		this.eventvenue = eventvenue;
		this.eventdate = eventdate;
	}

	public Event() {

	}

	public Long getEventid() {
		return eventid;
	}

	public void setEventid(Long eventid) {
		this.eventid = eventid;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEventvenue() {
		return eventvenue;
	}

	public void setEventvenue(String eventvenue) {
		this.eventvenue = eventvenue;
	}

	public java.sql.Date getEventdate() {
		return eventdate;
	}

	public void setEventdate(java.sql.Date eventdate) {
		this.eventdate = eventdate;
	}

//    @Column(length = 5000) //init with VARCHAR(1000)
//    public String content;
//    
//    @ElementCollection(fetch=FetchType.EAGER)
//    public List<Long> authorIds;
//    
//    public Article() {}
//    
//    public Article(User author, String title, String content) {
//        this.authorIds = Lists.newArrayList(author.id);
//        this.title = title;
//        this.content = content;
//        this.postedAt = new Date();
//    }

}