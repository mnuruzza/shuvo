package com.lcss.eduCov_backend.repository;

import com.lcss.eduCov_backend.model.PostReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReplyRepository extends JpaRepository<PostReply, Long> {
}
