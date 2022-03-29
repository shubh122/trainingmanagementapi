package in.capg.trainingmanagementapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.capg.trainingmanagementapi.domain.Training;
import in.capg.trainingmanagementapi.exception.TrainingIdException;
import in.capg.trainingmanagementapi.repository.TrainingRepository;
import in.capg.trainingmanagementapi.service.TrainingService;


@Service
public class TrainingServiceImpl implements TrainingService {
	@Autowired
	private TrainingRepository trainingRepository;
	@Override
	public Training saveOrUpdate(Training training) {
		try
		{
			training.setTrainingId(training.getTrainingId().toUpperCase());
			return trainingRepository.save(training);
		}
		catch(Exception ex)
		{
			throw new TrainingIdException("Training id :" +training.getTrainingId().toUpperCase()+"already exist");

	}
	}
	

	@Override
	public Training findTrainingByIdentifier(String TrainingId) {
		Training training =trainingRepository.findByTrainingId(TrainingId.toUpperCase());
		if(training==null)
		{
			throw new TrainingIdException("Training Id"+TrainingId.toUpperCase()+"does not exist");
			
		}
		return training;
	}

	@Override
	public Iterable<Training> findAllTraining() {
		
		return trainingRepository.findAll();
	}

	@Override
	public void deleteTrainingByTrainingIdentifier(String TrainingId) {
		// TODO Auto-generated method stub
		Training training =trainingRepository.findByTrainingId(TrainingId.toUpperCase());
		if(training==null)
		{
			throw new TrainingIdException("Training Id"+TrainingId.toUpperCase()+"does not exist");
			
		}
		trainingRepository.delete(training);
		
	}

}

