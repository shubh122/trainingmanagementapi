package in.capg.trainingmanagementapi.service;
import in.capg.trainingmanagementapi.domain.Training;


public interface TrainingService {
	public Training saveOrUpdate(Training training);
	public Training findTrainingByIdentifier(String trainingid);
	public Iterable<Training> findAllTraining();
	public void deleteTrainingByTrainingIdentifier(String trainingid);

}
