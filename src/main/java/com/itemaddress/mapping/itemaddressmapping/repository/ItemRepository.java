package com.itemaddress.mapping.itemaddressmapping.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itemaddress.mapping.itemaddressmapping.dataobject.Address;
import com.itemaddress.mapping.itemaddressmapping.dataobject.Item;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Integer> {

	@Query("select i from Item i left join i.address a where a.id=?1")
	List<Item> getItemByAddressId(int i);

	@Query("select i from Item i left join i.address a where a.id!=?1")
	List<Item> getNotMappedItemDataWithPassedAddressID(int i);

	@Modifying
	@Query("UPDATE Item SET fk_addressid=null where itemId=?1")
	int setaddressidToNullOnItemId(int id);

	@Query("select i from Item i where i.id=?1")
	List<Item> getAddressDataByItemId(int id);
	
	@Query("Select i from Item i where i.itemId =?1")
	Item  getByItem(int item);

//	@Transactional
//	@Modifying
//	@Query("delete from Item b where b.address=:address")
//	void deleteByAddressId(@Param("address")Item item); 
	
	void deleteByAddress(Address address);
	
	@Query("select i from Item i where i.itemName=?1")
	List<Item> getByItemName(String itemName);
	

	
	
	

	

}
