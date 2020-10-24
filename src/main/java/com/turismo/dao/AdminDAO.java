package com.turismo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.model.Admin;

public interface AdminDAO extends JpaRepository<Admin, Integer>{

}
