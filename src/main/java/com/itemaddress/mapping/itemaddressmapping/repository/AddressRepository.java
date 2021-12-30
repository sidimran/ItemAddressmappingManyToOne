package com.itemaddress.mapping.itemaddressmapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itemaddress.mapping.itemaddressmapping.dataobject.Address;

@Repository
@Transactional
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	@Query("select a from Address a where a.addressName=?1")
	List<Address> getByAddressName(String addressName);

}
