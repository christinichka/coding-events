package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message="Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message="Location cannot be left blank.")
    @Size(min = 3, max = 50, message= "Location must be between 3 and 50 characters")
    private String location;

    @AssertTrue
//    @NotBlank(message="Registration field is required.")
    private boolean registration;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @Positive(message="Number of attendees must be one or more.")
    private int numberOfAttendees;

    @AssertFalse
    private boolean mealProvided;

    public Event(String name, String description, String location, boolean registration, String contactEmail, int numberOfAttendees, boolean mealProvided) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.registration = registration;
        this.contactEmail = contactEmail;
        this.numberOfAttendees = numberOfAttendees;
        this.mealProvided = mealProvided;
        this.id = nextId;
        nextId++;
    }

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public boolean isMealProvided() {
        return mealProvided;
    }

    public void setMealProvided(boolean mealProvided) {
        this.mealProvided = mealProvided;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}