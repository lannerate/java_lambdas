package lambda.base.methodref;

/**
 * Created by apple on 1/24/16.
 */
public class Airtle {

		private String name;
		private String author;

		public Airtle() {
		}

		public Airtle(String name, String author) {
				this.name = name;
				this.author = author;
		}

		public String getName() {
				return name;
		}

		public String getAuthor() {
				return author;
		}
}
