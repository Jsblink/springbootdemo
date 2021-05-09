package com.smz.springbootdemo.dao;

import com.smz.springbootdemo.domain.SubscriberInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SubscriberInfoRepository extends JpaRepository<SubscriberInfo, Integer> {

/*    @Query("select s from SubscriberInfo s where s.userId = :userid")
    SubscriberInfo getSubscriberInfoByUserID(@Param("userid") String userId) ;*/

    @Query("select s from SubscriberInfo s where s.userId = ?1")
    SubscriberInfo getSubscriberInfoByUserID(String userId) ;

    @Query(value = " select s from  SubscriberInfo s")
    List<SubscriberInfo> queryAllSubscriberInfo();

    @Transactional
    @Modifying
    @Query("delete from SubscriberInfo s where s.userId = ?1 ")
    void deleteByUserId(String userId);

    @Query(value = " select s from  SubscriberInfo s")
    Page<SubscriberInfo> queryAllByPage(Pageable pageable);
}
