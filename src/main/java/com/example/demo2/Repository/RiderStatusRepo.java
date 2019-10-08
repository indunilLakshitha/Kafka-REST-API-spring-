package com.example.demo2.Repository;

import com.example.demo2.Model.RiderDetails;
import org.springframework.data.repository.CrudRepository;

public interface RiderStatusRepo extends CrudRepository<RiderDetails,Integer> {
}
