package pages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AppointmentData {

    public String facility;
    public boolean isReadmission;
    public String healthCareProgram;
    public String dateOfVisit;
    public String comments;

}
