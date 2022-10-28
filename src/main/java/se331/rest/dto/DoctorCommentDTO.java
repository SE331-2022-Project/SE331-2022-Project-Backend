package se331.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorCommentDTO {
    Long id;
    String doctor_name;
    String title;
    String comment;
    DoctorCommentPDTO patient;
}