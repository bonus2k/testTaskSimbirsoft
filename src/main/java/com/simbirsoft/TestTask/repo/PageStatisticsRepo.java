package com.simbirsoft.TestTask.repo;


import com.simbirsoft.TestTask.domain.PageStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageStatisticsRepo extends JpaRepository<PageStatistics, Long> {
}
