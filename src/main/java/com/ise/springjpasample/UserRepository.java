package com.ise.springjpasample;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// JpaRepository<操作対象のEntity, 操作対象Entityの主キーの型>
public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Override
    <S extends UserEntity> List<S> findAll(Example<S> example);

    List<UserEntity> findByName(String name);


}
