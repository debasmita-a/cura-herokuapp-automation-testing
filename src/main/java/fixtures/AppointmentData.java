package fixtures;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AppointmentData {

	@NonNull
    private String facility;
    private boolean isReadmission;
    @NonNull
    private String healthCareProgram;
    @NonNull
    private String dateOfVisit;
    private String comments;

}
