package se.jpdc.receptdemo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.jpdc.receptdemo.model.Step;
import se.jpdc.receptdemo.model.StepDTO;

import java.util.List;

@Repository
public interface StepsRepository extends JpaRepository<Step, Long> {
    public void deleteStepsByRecipeId(Long id);
    public List<Step> getStepsByRecipeId(Long id);
}
