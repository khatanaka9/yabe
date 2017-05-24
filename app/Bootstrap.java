import models.user.*;
import play.jobs.*;
import play.test.*;

@OnApplicationStart
public class Bootstrap extends Job {

	@Override
	public void doJob() {
		// e database is empty
		if (User.count() == 0) {
			Fixtures.loadModels("initial-data.yml");
		}
	}
}
