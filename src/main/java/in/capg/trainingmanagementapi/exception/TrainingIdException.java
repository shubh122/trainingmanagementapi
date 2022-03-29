package in.capg.trainingmanagementapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TrainingIdException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public TrainingIdException()
{
	super();
}
public TrainingIdException(String errMsg)
{
	super(errMsg);
}

}
