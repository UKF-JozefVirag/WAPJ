package business.generators.samples.title;

import javax.enterprise.inject.Produces;

import business.qualifiers.Fake;
import business.qualifiers.Real;

public class SampleBookTitleProducer {

	@Produces @Fake
	public String produceFakeBookTitle() {
		return "this is a fake title";
	}
	
	@Produces @Real
	public String produceRealBookTitle() {
		return "Beggining java EE";
	}
	
}
