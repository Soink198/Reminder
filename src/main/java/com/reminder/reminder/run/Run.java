package com.reminder.reminder.run;

import java.time.LocalDateTime;

public record Run(Integer id, String title, LocalDateTime startDate, LocalDateTime compDate, Integer miles) {

}
