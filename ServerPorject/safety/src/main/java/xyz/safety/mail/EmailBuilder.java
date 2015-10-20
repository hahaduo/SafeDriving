package xyz.safety.mail;

public interface EmailBuilder {

	EmailBuilder from(String address);

	EmailBuilder to(String... addresses);

	EmailBuilder cc(String... addresses);

	EmailBuilder bcc(String... addresses);

	EmailBuilder withSubject(String subject);

	EmailBuilder withBody(String body);

	EmailBuilder withMailType(int type);

	EmailBuilder withAttachment(String... attachments);

	void send();
}