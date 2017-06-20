package com.keirnellyer.portfolio;

import java.time.LocalDate;
import java.util.Objects;

public class Profile {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String location;
    private String email;

	public Profile(String firstName, String lastName, LocalDate birthDate, String location, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.location = location;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Profile)) return false;
		Profile profile = (Profile) o;
		return Objects.equals(firstName, profile.firstName) &&
				Objects.equals(lastName, profile.lastName) &&
				Objects.equals(birthDate, profile.birthDate) &&
				Objects.equals(location, profile.location) &&
				Objects.equals(email, profile.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, birthDate, location, email);
	}

	@Override
	public String toString() {
		return "Profile{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birthDate=" + birthDate +
				", location='" + location + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
