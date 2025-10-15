package riccardogulin.u5d8.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorsPayload {
	private String message;
	private LocalDateTime timestamp;
}
