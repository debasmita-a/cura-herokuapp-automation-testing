package pages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AppointmentData {

    private String facility;
    private boolean isReadmission;
    private String healthCareProgram;
    private String dateOfVisit;
    private String comments;

}
