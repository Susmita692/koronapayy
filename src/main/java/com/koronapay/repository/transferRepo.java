package com.koronapay.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.koronapay.entity.*;

public interface transferRepo extends JpaRepository<Transfer,Integer>{

	Transfer findByOid(String oid);
}
