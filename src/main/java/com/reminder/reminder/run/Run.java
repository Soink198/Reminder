package com.reminder.reminder.run;

import java.time.LocalDateTime;
import jakarta.validation.constraints.*;

public record Run(
        Integer id,
        @NotEmpty String title,
        LocalDateTime startDate,
        LocalDateTime compDate,
        @Positive Integer miles) {

    public static Run withDefault(Integer id, String title, LocalDateTime startDate, LocalDateTime compDate,
            Integer miles) {
        return new Run(
                id,
                title != null ? title : "Default Run",
                startDate != null ? startDate : LocalDateTime.now(),
                compDate != null ? compDate : LocalDateTime.now().plusHours(1),
                miles != null ? miles : 0);
    }
}
