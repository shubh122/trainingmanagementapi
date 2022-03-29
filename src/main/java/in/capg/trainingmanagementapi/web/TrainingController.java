package in.capg.trainingmanagementapi.web;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.capg.trainingmanagementapi.domain.Training;
import in.capg.trainingmanagementapi.service.TrainingService;
import in.capg.trainingmanagementapi.serviceImpl.MapValidationErrorService;

@RestController
@RequestMapping("/api/training")

public class TrainingController {
	@Autowired
	private TrainingService trainingService;
	@Autowired
	private MapValidationErrorService mapErrorValidationService;
	@PostMapping("")
	public ResponseEntity<?> addNewTraining(@Valid @RequestBody Training training, BindingResult result)
	{
		ResponseEntity<?> errorMap=mapErrorValidationService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Training saveTraining=trainingService.saveOrUpdate(training);
		return new ResponseEntity<Training>(saveTraining,HttpStatus.CREATED);
	}
	@PutMapping("/update/{Trainingid}")
	public ResponseEntity<?> UpdateById(@PathVariable String Trainingid){
		Training training=trainingService.findTrainingByIdentifier(Trainingid);	
		Training saveTraining=trainingService.saveOrUpdate(training);
		return new ResponseEntity<Training>(saveTraining,HttpStatus.CREATED);
	}
	@GetMapping("/{Trainingid}")
	public ResponseEntity<?> getTrainingById(@PathVariable String Trainingid)
	{
		Training training=trainingService.findTrainingByIdentifier(Trainingid);
		return new ResponseEntity<Training>(training,HttpStatus.OK);
	}
	@GetMapping("/all")
	public Iterable<Training> getAllTrainings(){
		return trainingService.findAllTraining();
	}
	@DeleteMapping("/{Trainingid}")
	public ResponseEntity<?> deleteTraining(@PathVariable String Trainingid )
	{
		trainingService.deleteTrainingByTrainingIdentifier(Trainingid);
		return new ResponseEntity<String>("Training with id"+Trainingid.toUpperCase()+"deletd Succesfully",HttpStatus.OK);
		
	}
	
	
}