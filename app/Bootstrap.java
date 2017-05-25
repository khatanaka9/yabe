import models.comment.*;
import models.post.*;
import models.user.*;
import play.jobs.*;

@OnApplicationStart
public class Bootstrap extends Job {

	@Override
	public void doJob() {
		// e database is empty
		if (User.count() == 0) {
			// Fixtures.loadModels("initial-data.yml");

			User user1 = new User("email1", "passsword", "hatanaka")
					.save();
			User user2 = new User("email2", "passsword", "harita").save();

			Post post1 = new Post(user1, "post1", "content1").save();
			Post post2 = new Post(user1, "post2", "content2").save();
			Post post3 = new Post(user2, "post3", "content3").save();

			new Comment(post1, "comment1", "content1").save();
			new Comment(post2, "comment2", "content2").save();
			new Comment(post3, "comment3", "content3").save();



		}
	}
}
