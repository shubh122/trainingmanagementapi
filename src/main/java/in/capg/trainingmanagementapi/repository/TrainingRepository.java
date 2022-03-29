package in.capg.trainingmanagementapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.capg.trainingmanagementapi.domain.Training;
@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {
	Training findByTrainingId(String trainingId);
	Iterable<Training> findAll();
	
}
