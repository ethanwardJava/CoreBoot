package com.arcade.coreboot.repository;

import com.arcade.coreboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query("SELECT s FROM Customer s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Customer> findByName(@Param("name") String name);

    @Query("SELECT s FROM Customer s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%')) AND s.email = :email")
    Optional<Customer> findByNameAndEmail(@Param("name") String name, @Param("email") String email);

    Customer findByEmail(String email);

}
