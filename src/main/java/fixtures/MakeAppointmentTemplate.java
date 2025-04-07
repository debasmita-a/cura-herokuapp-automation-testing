package fixtures;

import com.github.javafaker.Faker;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class MakeAppointmentTemplate implements TemplateLoader{

	@Override
	public void load() {
		Fixture.of(AppointmentData.class).addTemplate("valid", new Rule() {{
			add("facility", random("Tokyo CURA Healthcare Center", "Hongkong CURA Healthcare Center", "Seoul CURA Healthcare Center"));
			add("isReadmission", random(true, false));
			add("healthCareProgram", random("Medicare", "Medicaid", "None"));
			add("dateOfVisit", random("10/04/2025", "25/04/2025", "19/05/2025"));
			add("comments", random(new Faker().lorem().paragraph()));
		}});
	}

	
}
